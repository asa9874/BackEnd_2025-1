package com.example.bcsd.dto.RequestDto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleUpdateRequestDto {
    @NotNull
    private Long boardId;
    @NotNull
    @Size(min = 1, max = 100)
    private String title;
    @NotNull
    @Size(min = 1, max = 1000)
    private String content;
}
