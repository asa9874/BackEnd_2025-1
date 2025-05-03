package com.example.bcsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bcsd.dto.ResponseDto.ArticleResponseDto;
import com.example.bcsd.service.ArticleService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/articles")
public class ArticleController {
    
    @Autowired
    private ArticleService articleService;

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponseDto> getArticle(@PathVariable String id){
        ArticleResponseDto articleDto = articleService.getArticle(id);
        return ResponseEntity.ok().body(articleDto);
    }

    @PostMapping()
    public ResponseEntity<ArticleResponseDto> createArticle(@RequestBody String article){
        ArticleResponseDto articleDto = articleService.createArticle(article);
        return ResponseEntity.ok().body(articleDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleResponseDto> updateArticle(@PathVariable String id, @RequestBody String article){
        ArticleResponseDto articleDto = articleService.updateArticle(id, article);
        return ResponseEntity.ok().body(articleDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable String id){
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
    
    
}
