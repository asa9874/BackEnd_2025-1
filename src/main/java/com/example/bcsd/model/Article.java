package com.example.bcsd.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Member author;
    private String title;
    private String content;

    @Builder.Default
    private LocalDateTime createdDate = LocalDateTime.now();
    
    @Builder.Default
    private LocalDateTime modifiedDate = LocalDateTime.now();

    public void update(Board board, String title, String content) {
        this.board = board;
        this.title = title;
        this.content = content;
        this.modifiedDate = LocalDateTime.now();
    }
}
