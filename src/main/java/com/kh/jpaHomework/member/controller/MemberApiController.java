package com.kh.jpaHomework.member.controller;

import com.kh.jpaHomework.member.Dto.MemberDto;
import com.kh.jpaHomework.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/member")
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    // 회원가입
    @PostMapping
    public Long join(@RequestBody MemberDto dto) {
        return memberService.join(dto);
    }

    // 회원 리스트 출력
    @GetMapping
    public List<MemberDto> memberDtoList() {
        return memberService.memberDtoList();
    }


}
