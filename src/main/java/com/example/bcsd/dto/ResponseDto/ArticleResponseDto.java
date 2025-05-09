package com.example.bcsd.dto.ResponseDto;

import com.example.bcsd.model.Article;

public class ArticleResponseDto {
    private Long id;
    private String title;
    private String content;
    private Long boardId;
    private Long memberId;
    private String createdAt;
    private String updatedAt;

    public ArticleResponseDto(Long id, Long boardId, Long memberId, String title, String content,
            String createdAt, String updatedAt) {
        this.id = id;
        this.boardId = boardId;
        this.memberId = memberId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public ArticleResponseDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Long getBoardId() {
        return boardId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public static ArticleResponseDto from(Article article) {
        return new ArticleResponseDto(
                article.getId(),
                article.getBoard().getId(),
                article.getMember().getId(),
                article.getTitle(),
                article.getContent(),
                article.getCreatedAt().toString(),
                article.getUpdatedAt().toString());
    }
}
