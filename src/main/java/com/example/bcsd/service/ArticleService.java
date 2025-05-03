package com.example.bcsd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bcsd.repository.ArticleRepository;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public String getArticle(String id) {
        String article = articleRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new IllegalArgumentException("해당 기사가 없습니다."));
        
        return article;
    }

    public String createArticle(String article) {
        return "";
    }

    public String updateArticle(String id, String articleContent) {
        String article = articleRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new IllegalArgumentException("해당 기사가 없습니다."));
        
        return "";
    }

    public void deleteArticle(String id) {
        String article = articleRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new IllegalArgumentException("해당 기사가 없습니다."));
    }
}
