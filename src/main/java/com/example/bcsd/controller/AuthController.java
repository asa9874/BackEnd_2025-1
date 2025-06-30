package com.example.bcsd.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bcsd.dto.RequestDto.AuthLoginRequestDto;
import com.example.bcsd.dto.RequestDto.AuthRegisterRequestDto;
import com.example.bcsd.dto.ResponseDto.LoginResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody AuthLoginRequestDto loginRequest) {
        return null;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody AuthRegisterRequestDto registerRequest) {
        return null;
    }

}
