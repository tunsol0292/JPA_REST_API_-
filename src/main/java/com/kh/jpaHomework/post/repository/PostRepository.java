package com.kh.jpaHomework.post.repository;

import com.kh.jpaHomework.post.entity.PostEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepository {

    private final EntityManager entityManager;

    public void save(PostEntity entity) {
        entityManager.persist(entity);
    }

    public List<PostEntity> findByMemberId(Long memberId) {
        return entityManager.createQuery(
                        "SELECT p FROM PostEntity p WHERE p.member.id = :memberId", PostEntity.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }
}
