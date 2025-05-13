package com.example.bcsd.dto.ResponseDto;

import java.time.LocalDate;

import com.example.bcsd.model.Article;

public record ArticleResponseDto(
        Long id,
        Long boardId,
        Long memberId,
        String title,
        String content,
        String created_date,
        String modified_date) {

    public static ArticleResponseDto from(Article article) {
        String updatedAt = article.getUpdatedAt() != null ? article.getUpdatedAt().toString() : LocalDate.now().toString();
        String createdAt = article.getCreatedAt() != null ? article.getCreatedAt().toString() : LocalDate.now().toString();
        return new ArticleResponseDto(
                article.getId(),
                article.getBoard().getId(),
                article.getMember().getId(),
                article.getTitle(),
                article.getContent(),
                createdAt,
                updatedAt);
    }
}
