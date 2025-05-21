package com.example.bcsd.dto.ResponseDto;

import com.example.bcsd.model.Board;

public class BoardResponseDto {
    private Long id;
    private String title;

    public BoardResponseDto(Long id, String title) {
        this.id = id;
        this.title = title;
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

    public static BoardResponseDto from(Board board) {
        return new BoardResponseDto(board.getId(), board.getTitle());
    }
}
