package com.example.bcsd.dto.RequestDto;

public record AuthRegisterRequestDto(
    String name,
    String email,
    String password
) {
    
}
