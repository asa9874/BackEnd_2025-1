package com.example.bcsd.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.bcsd.model.Article;

@Component
public class ArticleRepository {
    private List<Article> articles = new ArrayList<>(); // 데이터베이스 대용

    public ArticleRepository() { // 초기 데이터
        articles.add(new Article("제목1", "내용1"));
    }

    public Optional<Article> findById(Long id) {
        return articles.stream()
                       .filter(article -> article.getId().equals(id))
                       .findFirst();
    }

    public void deleteById(Long id) {
        articles.removeIf(article -> article.getId().equals(id));
    }

    public void save(Article article) {
        // 기존에 동일 id의 Article이 있다면 삭제후 추가(업데이트)
        deleteById(article.getId());
        articles.add(article);
    }
}
