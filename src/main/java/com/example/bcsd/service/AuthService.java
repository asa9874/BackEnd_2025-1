package com.example.bcsd.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.bcsd.dto.RequestDto.AuthLoginRequestDto;
import com.example.bcsd.dto.RequestDto.AuthRegisterRequestDto;
import com.example.bcsd.dto.ResponseDto.LoginResponseDto;
import com.example.bcsd.jwt.JwtTokenProvider;
import com.example.bcsd.model.Member;
import com.example.bcsd.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public void register(AuthRegisterRequestDto requestDto) {
        if (memberRepository.existsByEmail(requestDto.email())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        Member member = Member.builder()
                .email(requestDto.email())
                .password(passwordEncoder.encode(requestDto.password()))
                .build();
        memberRepository.save(member);
    }

    public LoginResponseDto login(AuthLoginRequestDto requestDto) {
        Member member = memberRepository.findByEmail(requestDto.email())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이메일입니다."));

        if (!passwordEncoder.matches(requestDto.password(), member.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        String token = jwtTokenProvider.createToken(member.getEmail(), member.getId());
        return new LoginResponseDto(token);
    }
}
