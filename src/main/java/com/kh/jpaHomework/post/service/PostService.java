package com.kh.jpaHomework.post.service;

import com.kh.jpaHomework.member.Repository.MemberRepository;
import com.kh.jpaHomework.member.entity.MemberEntity;
import com.kh.jpaHomework.post.Dto.PostDto;
import com.kh.jpaHomework.post.entity.PostEntity;
import com.kh.jpaHomework.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public List<PostDto> getPostsByMember(Long memberId) {
        return postRepository.findByMemberId(memberId)
                .stream()
                .map(PostEntity::toDto)
                .toList();
    }

    public PostDto createPost(PostDto dto) {
        MemberEntity member = memberRepository.memberList().stream()
                .filter(m -> m.getId().equals(dto.getMemberId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Member not found"));

        PostEntity post = PostEntity.from(dto, member);
        postRepository.save(post);
        return post.toDto();
    }
}
