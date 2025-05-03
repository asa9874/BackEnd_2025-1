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

    public ArticleResponseDto getArticle(Long id) {
        Article article = articleRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new IllegalArgumentException("해당 기사가 없습니다."));
        return ArticleResponseDto.from(article);
    }

    public ArticleResponseDto createArticle(String title, String content) {
        Article article = new Article(title, content);
        articleRepository.save(article);
        return ArticleResponseDto.from(article);
    }

    public ArticleResponseDto updateArticle(Long id, String title, String content) {
        Article article = articleRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new IllegalArgumentException("해당 기사가 없습니다."));
        article.setTitle(title);
        article.setContent(content);
        articleRepository.save(article);

        return ArticleResponseDto.from(article);
    }

    public void deleteArticle(Long id) {
        Article article = articleRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new IllegalArgumentException("해당 기사가 없습니다."));
        articleRepository.deleteById(article.getId());
    }
}
