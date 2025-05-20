package com.example.bcsd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bcsd.dto.RequestDto.MemberUpdateRequestDto;
import com.example.bcsd.dto.ResponseDto.MemberReponseDto;
import com.example.bcsd.exception.DeletionNotAllowedException;
import com.example.bcsd.exception.EmailAlreadyExistsException;
import com.example.bcsd.exception.NotFoundException;
import com.example.bcsd.model.Article;
import com.example.bcsd.model.Member;
import com.example.bcsd.repository.ArticleRepository;
import com.example.bcsd.repository.MemberRepository;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ArticleRepository articleRepository;

    public MemberReponseDto updateMember(Long memberId, MemberUpdateRequestDto requestDto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new NotFoundException("회원 못찾음"));
        
        List<Member> members = memberRepository.findAll();

        members.stream()
                .filter(m -> m.getId() != memberId)
                .forEach(m -> {
                    if (m.getEmail().equals(requestDto.getEmail())) {
                        throw new EmailAlreadyExistsException("이미 존재하는 이메일입니다.");
                    }
                });
        member.setEmail(requestDto.getEmail());
        memberRepository.save(member);
        return MemberReponseDto.from(member);
    }

    public void deleteMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new NotFoundException("회원 못찾음"));
        
        List<Article> articles = articleRepository.findByAuthorId(memberId);
        if (!articles.isEmpty()) {
            throw new DeletionNotAllowedException("작성한 게시글이 존재하여 삭제할 수 없습니다.");
        }
        
        memberRepository.deleteById(memberId);
    }


}
