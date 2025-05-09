package com.example.bcsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bcsd.service.ArticleService;
import com.example.bcsd.service.BoardService;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private BoardService boardService;

    @GetMapping
    public String getPosts(Model model) {
        Long boardId = 1L; 
        System.out.println();
        model.addAttribute("board", boardService.getBoard(boardId));
        model.addAttribute("articles", articleService.getArticlesByBoardId(boardId));
        return "posts";
    }
}
