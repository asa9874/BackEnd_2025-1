package com.example.bcsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bcsd.service.ArticleService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@Controller
@RequestMapping("/articles")
public class ArticleController {
    
    @Autowired
    private ArticleService articleService;

    @GetMapping("/{id}")
    public ResponseEntity<String> getArticle(@PathVariable String id){
        String article = articleService.getArticle(id);
        return ResponseEntity.ok().body(article);
    }

    @PostMapping()
    public ResponseEntity<String> createArticle(@RequestBody String article){
        String createdArticle = articleService.createArticle(article);
        return ResponseEntity.ok().body(createdArticle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateArticle(@PathVariable String id, @RequestBody String article){
        String updatedArticle = articleService.updateArticle(id, article);
        return ResponseEntity.ok().body(updatedArticle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable String id){
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
    
    
}
