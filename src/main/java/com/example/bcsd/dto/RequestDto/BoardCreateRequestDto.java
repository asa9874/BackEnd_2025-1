package com.example.bcsd.dto.RequestDto;

public class BoardCreateRequestDto {
    private String title;

    public BoardCreateRequestDto(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
