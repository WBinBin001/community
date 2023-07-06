package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.dto.QuestionDTO;
import com.example.servingwebcontent.service.QuestionService;
import com.example.servingwebcontent.dto.CommentDTO;
import com.example.servingwebcontent.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

/**
 * Created by codedrinker on 2019/5/21.
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id, Model model) {
        List<CommentDTO> comments = commentService.listByQuestionId(id);

        QuestionDTO questionDTO = questionService.getById(id);
        questionService.incView(id);
        model.addAttribute("question", questionDTO);
        model.addAttribute("comments", comments);

        return "question";
    }
}

