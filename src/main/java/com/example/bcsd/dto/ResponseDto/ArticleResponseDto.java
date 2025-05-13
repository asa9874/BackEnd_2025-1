package com.example.bcsd.dto.ResponseDto;

import com.example.bcsd.model.Article;

public class ArticleResponseDto {
    private Long id;
    private Long board_id;
    private Long author_id;
    private String title;
    private String author;
    private String date;
    private String content;

    public ArticleResponseDto(Long id, Long board_id, Long author_id, String title, String author, String date,
            String content) {
        this.id = id;
        this.board_id = board_id;
        this.author_id = author_id;
        this.title = title;
        this.author = author;
        this.date = date;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public Long getId() {
        return id;
    }

    public Long getBoardId() {
        return board_id;
    }

    public Long getAuthorId() {
        return author_id;
    }

    public static ArticleResponseDto from(Article article) {
        return new ArticleResponseDto(
                article.getId(),
                article.getBoard().getId(),
                article.getMember().getId(),
                article.getTitle(),
                article.getMember().getName(),
                article.getCreatedAt().toString(),
                article.getContent());
    }
}
