package com.example.bcsd.dto.ResponseDto;

import com.example.bcsd.model.Member;

public record MemberReponseDto(
        Long id,
        String name,
        String email) {

    public static MemberReponseDto from(Member member) {
        return new MemberReponseDto(
                member.getId(),
                member.getName(),
                member.getEmail()
        );
    }
}
