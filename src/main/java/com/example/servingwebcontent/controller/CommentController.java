package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.dto.CommentCreateDTO;
import com.example.servingwebcontent.dto.CommentDTO;
import com.example.servingwebcontent.enums.CommentTypeEnum;

import com.example.servingwebcontent.model.Comment;
import com.example.servingwebcontent.mapper.CommentMapper;
import com.example.servingwebcontent.service.CommentService;
import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.dto.ResultDTO;
import com.example.servingwebcontent.exception.CustomizeErrorCode;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Created by codedrinker on 2019/5/30.
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentCreateDTO commentCreateDTO,
                       HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }

        if (commentCreateDTO == null || StringUtils.isBlank(commentCreateDTO.getContent())) {
            return ResultDTO.errorOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
        }

        Comment comment = new Comment();
        comment.setParentId(commentCreateDTO.getParentId());
        comment.setContent(commentCreateDTO.getContent());
        comment.setType(commentCreateDTO.getType());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        comment.setLikeCount(0L);
        commentService.insert(comment, user);
        return ResultDTO.okOf();

    }

    @ResponseBody
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public ResultDTO<List<CommentDTO>> comments(@PathVariable(name = "id") Long id) {
        List<CommentDTO> commentDTOS = commentService.listByTargetId(id, CommentTypeEnum.COMMENT);
        return ResultDTO.okOf(commentDTOS);
    }

}

