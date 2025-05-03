package com.example.bcsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bcsd.dto.RequestDto.ArticleCreateRequestDto;
import com.example.bcsd.dto.RequestDto.ArticleUpdateRequestDto;
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
    public ResponseEntity<ArticleResponseDto> getArticle(@PathVariable Long id){
        ArticleResponseDto articleDto = articleService.getArticle(id);
        return ResponseEntity.ok().body(articleDto);
    }

    @PostMapping()
    public ResponseEntity<ArticleResponseDto> createArticle(@RequestBody ArticleCreateRequestDto requestDto){
        ArticleResponseDto articleDto = articleService.createArticle(requestDto.getTitle(), requestDto.getContent());
        return ResponseEntity.ok().body(articleDto);
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
