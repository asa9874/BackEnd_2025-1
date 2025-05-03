package com.example.bcsd.repository;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.bcsd.model.Article;

@Component
public class ArticleRepository {
    public Optional<Article> findById(Long id) {
        return Optional.empty();
    }

    public void deleteById(Long id) {

    }

    public void save(String article) {
        
    }

    public void update(String article) {

    }

}
