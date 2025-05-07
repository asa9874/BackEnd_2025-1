package com.example.bcsd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bcsd.dto.RequestDto.ArticleCreateRequestDto;
import com.example.bcsd.dto.RequestDto.ArticleUpdateRequestDto;
import com.example.bcsd.dto.ResponseDto.ArticleResponseDto;
import com.example.bcsd.service.ArticleService;




@RestController
@RequestMapping("/articles")
public class ArticleController {
    
    @Autowired
    private ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<ArticleResponseDto>> getArticles(){
        List<ArticleResponseDto> articles = articleService.getArticles();
        return ResponseEntity.ok().body(articles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponseDto> getArticle(@PathVariable Long id){
        ArticleResponseDto articleDto = articleService.getArticle(id);
        return ResponseEntity.ok().body(articleDto);
    }

    @PostMapping
    public ResponseEntity<ArticleResponseDto> createArticle(@RequestBody ArticleCreateRequestDto requestDto){
        ArticleResponseDto articleDto = articleService.createArticle(requestDto.getTitle(), requestDto.getContent());
        return ResponseEntity.status(HttpStatus.CREATED).body(articleDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleResponseDto> updateArticle(@PathVariable Long id, @RequestBody ArticleUpdateRequestDto requestDto){
        ArticleResponseDto articleDto = articleService.updateArticle(id, requestDto.getTitle(), requestDto.getContent());
        return ResponseEntity.ok().body(articleDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id){
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
    
}
