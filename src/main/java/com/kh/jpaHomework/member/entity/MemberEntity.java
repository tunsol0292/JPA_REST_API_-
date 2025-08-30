package com.kh.jpaHomework.member.entity;

import com.kh.jpaHomework.member.Dto.MemberDto;
import com.kh.jpaHomework.post.entity.PostEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "MEMBER")
@Getter
@Setter
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "member")
    private List<PostEntity> posts;

    public static MemberEntity from(MemberDto dto) {
        MemberEntity entity = new MemberEntity();
        entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        return entity;
    }

    public MemberDto toDto() {
        MemberDto dto = new MemberDto();
        dto.setId(this.id);
        dto.setUsername(this.username);
        dto.setEmail(this.email);
        return dto;
    }
}
