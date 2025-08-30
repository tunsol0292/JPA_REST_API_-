package com.kh.jpaHomework.post.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {

    private Long id;
    private String title;
    private String content;
    private Long memberId;

}
