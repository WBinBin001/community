package com.example.servingwebcontent.dto;

import lombok.Data;

/**
 * Created by codedrinker on 2019/5/30.
 */
@Data
public class CommentDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
