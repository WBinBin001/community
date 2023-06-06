package com.example.servingwebcontent.controller;


import com.example.servingwebcontent.dto.PaginationDTO;
import com.example.servingwebcontent.QuestionService.QuestionService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size
    ) {

        PaginationDTO pagination = (PaginationDTO) questionService.list(page, size);
        model.addAttribute("pagination", pagination);
       return "index";
    }


}