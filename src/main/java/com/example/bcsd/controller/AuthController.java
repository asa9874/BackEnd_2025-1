package com.example.bcsd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bcsd.dto.RequestDto.AuthLoginRequestDto;
import com.example.bcsd.dto.RequestDto.AuthRegisterRequestDto;
import com.example.bcsd.dto.ResponseDto.LoginResponseDto;
import com.example.bcsd.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody AuthLoginRequestDto requestDto) {
        LoginResponseDto responseDto = authService.login(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody AuthRegisterRequestDto requestDto) {
        authService.register(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
