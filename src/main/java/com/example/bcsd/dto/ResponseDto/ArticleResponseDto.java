package com.example.bcsd.dto.ResponseDto;

import com.example.bcsd.model.Article;

public class ArticleResponseDto {
    private Long id;
    private Long author_id;
    private Long board_id;
    private String title;
    private String content;
    private String created_date;
    private String modified_date;

    public ArticleResponseDto(Long id, Long board_id, Long author_id, String title, String author, String date,
            String content) {
        this.id = id;
        this.board_id = board_id;
        this.author_id = author_id;
        this.title = title;
        this.content = content;
        this.created_date = date;
        this.modified_date = date;
    }

    public String getTitle() {
        return title;
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

    public String getCreatedDate() {
        return created_date;
    }

    public String getModifiedDate() {
        return modified_date;
    }

    public static ArticleResponseDto from(Article article) {
        String updatedAt = article.getUpdatedAt() != null ? article.getUpdatedAt().toString() : article.getCreatedAt().toString();
        return new ArticleResponseDto(
                article.getId(),
                article.getBoard().getId(),
                article.getMember().getId(),
                article.getTitle(),
                article.getContent(),
                article.getCreatedAt().toString(),
                updatedAt);
    }
}
