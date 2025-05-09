package com.example.bcsd.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.bcsd.model.Article;

@Component
public class ArticleRepository {
    private static Long DEFAULT_ID = 0L;
    private List<Article> articles = new ArrayList<>(); // 데이터베이스 대용

    public ArticleRepository() { // 초기 데이터
        save(new Article(1L, 1L, 1L, "제목1", "내용1"));
        save(new Article(2L, 2L, 2L, "제목2", "내용2"));
    }

    public Long getNextId() {
        return ++DEFAULT_ID;
    }

    public Optional<Article> findById(Long id) {
        return articles.stream()
                .filter(article -> article.getId().equals(id))
                .findFirst();
    }

    public List<Article> findAll() {
        return new ArrayList<>(articles); // 복제 리스트 반환(변경 방지)
    }

    public void deleteById(Long id) {
        articles.removeIf(article -> article.getId().equals(id));
    }

    public void save(Article article) { //저장(수정)
        if(article.getId() == null){
            article.setId(getNextId()); //생성
            article.setCreatedAt(LocalDateTime.now());
        } 
        else{//수정
            deleteById(article.getId());     
            article.setUpdatedAt(LocalDateTime.now());
        }
        articles.add(article);
    }
}
