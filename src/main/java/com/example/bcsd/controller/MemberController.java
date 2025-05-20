package com.example.bcsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bcsd.dto.RequestDto.MemberUpdateRequestDto;
import com.example.bcsd.dto.ResponseDto.MemberReponseDto;
import com.example.bcsd.service.MemberService;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PutMapping("/{memberId}")
    public ResponseEntity<MemberReponseDto> updateMember(@PathVariable(name = "memberId") Long memberId,@RequestBody MemberUpdateRequestDto requestDto) {
        MemberReponseDto responseDto = memberService.updateMember(memberId,requestDto);
        return ResponseEntity.ok().body(responseDto);
    }
}
