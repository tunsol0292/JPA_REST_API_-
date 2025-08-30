package com.kh.jpaHomework.post.controller;

import com.kh.jpaHomework.post.Dto.PostDto;
import com.kh.jpaHomework.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/post")
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    // 특정 회원 게시글 조회
    @GetMapping("/member/{memberId}")
    public List<PostDto> getPostsByMember(@PathVariable Long memberId) {
        return postService.getPostsByMember(memberId);
    }

    // 게시글 작성
    @PostMapping
    public PostDto createPost(@RequestBody PostDto dto) {
        return postService.createPost(dto);
    }
}
