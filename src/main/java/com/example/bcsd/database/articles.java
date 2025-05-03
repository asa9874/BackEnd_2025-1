package com.example.bcsd.database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.bcsd.model.Article;

public class articles {
    private List<Article> articles = new ArrayList<>();

    public void addArticle(Article article) {
        articles.add(article);
    }

    public List<Article> getAllArticles() {
        return Collections.unmodifiableList(articles);
    }

    public boolean removeArticle(Article article) {
        return articles.remove(article);
    }
    
    public Article findArticleById(Long id) {
        for (Article article : articles) {
            if(article.getId().equals(id)) {
                return article;
            }
        }
        return null;
    }
}
