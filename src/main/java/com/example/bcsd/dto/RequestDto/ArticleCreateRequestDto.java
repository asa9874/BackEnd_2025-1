package com.example.bcsd.dto.RequestDto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ArticleCreateRequestDto {

    @NotNull
    @JsonProperty("board_id")
    private Long boardId;

    @NotNull
    @JsonProperty("author_id")
    private Long authorId;

    @NotNull
    @Size(min = 1, max = 100)
    private String title;

    @NotNull
    @Size(min = 1, max = 1000)
    private String content;

}
