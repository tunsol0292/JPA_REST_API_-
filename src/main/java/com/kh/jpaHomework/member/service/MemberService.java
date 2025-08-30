package com.kh.jpaHomework.member.service;

import com.kh.jpaHomework.member.Dto.MemberDto;
import com.kh.jpaHomework.member.Repository.MemberRepository;
import com.kh.jpaHomework.member.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long join(MemberDto dto) {
        MemberEntity entity = MemberEntity.from(dto);
        memberRepository.join(entity);
        return entity.getId();
    }

    public List<MemberDto> memberDtoList() {
        return memberRepository.memberList()
                .stream()
                .map(MemberEntity::toDto)
                .toList();
    }
}
