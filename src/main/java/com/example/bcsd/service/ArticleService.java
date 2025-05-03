package com.example.bcsd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bcsd.dto.ResponseDto.ArticleResponseDto;
import com.example.bcsd.model.Article;
import com.example.bcsd.repository.ArticleRepository;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public ArticleResponseDto getArticle(String id) {
        Article article = articleRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new IllegalArgumentException("해당 기사가 없습니다."));
        return ArticleResponseDto.from(article);
    }

    public ArticleResponseDto createArticle(String article) {

        return null;
    }

    public ArticleResponseDto updateArticle(String id, String articleContent) {
        Article article = articleRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new IllegalArgumentException("해당 기사가 없습니다."));
        
        return ArticleResponseDto.from(article);
    }

    public void deleteArticle(String id) {
        Article article = articleRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new IllegalArgumentException("해당 기사가 없습니다."));

        
    }
}
