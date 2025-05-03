package com.example.bcsd.model;

public class Article {
    private static Long DEFAULT_ID = 0L; 
    private Long id;
    private String title;
    private String content;


    public Article(String title, String content) {
        DEFAULT_ID+=1;
        this.id = DEFAULT_ID;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
