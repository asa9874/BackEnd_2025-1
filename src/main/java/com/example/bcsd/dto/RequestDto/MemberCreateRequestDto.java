package com.example.bcsd.dto.RequestDto;

import jakarta.validation.constraints.Email;
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
public class MemberCreateRequestDto {
    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(min = 6, max = 100)
    private String password;
    @NotNull
    @Size(min = 1, max = 50)
    private String name;
}
