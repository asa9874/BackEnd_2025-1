package com.example.bcsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bcsd.service.ArticleService;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    public String getPosts(Model model) {
        model.addAttribute("articles", articleService.getArticles());
        return "posts";
    }
}
