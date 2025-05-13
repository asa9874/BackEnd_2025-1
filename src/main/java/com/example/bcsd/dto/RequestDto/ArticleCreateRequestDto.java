package com.example.bcsd.dto.RequestDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArticleCreateRequestDto {

    @JsonProperty("board_id")
    private Long board_id;

    @JsonProperty("author_id")
    private Long author_id;

    private String title;
    private String content;

    public ArticleCreateRequestDto() {
    }

    public ArticleCreateRequestDto(Long board_id, Long author_id, String title, String content) {
        this.board_id = board_id;
        this.author_id = author_id;
        this.title = title;
        this.content = content;
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

    public Long getBoardId() {
        return board_id;
    }

    public void setBoardId(Long board_id) {
        this.board_id = board_id;
    }

    public Long getAuthorId() {
        return author_id;
    }

    public void setAuthorId(Long author_id) {
        this.author_id = author_id;
    }

}
