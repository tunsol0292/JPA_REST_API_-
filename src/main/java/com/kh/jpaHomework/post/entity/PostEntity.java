package com.kh.jpaHomework.post.entity;

import com.kh.jpaHomework.member.entity.MemberEntity;
import com.kh.jpaHomework.post.Dto.PostDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "POST")
@Getter
@Setter
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    public static PostEntity from(PostDto dto, MemberEntity member) {
        PostEntity entity = new PostEntity();
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setMember(member);
        return entity;
    }

    public PostDto toDto() {
        PostDto dto = new PostDto();
        dto.setId(this.id);
        dto.setTitle(this.title);
        dto.setContent(this.content);
        dto.setMemberId(this.member.getId());
        return dto;
    }
}
