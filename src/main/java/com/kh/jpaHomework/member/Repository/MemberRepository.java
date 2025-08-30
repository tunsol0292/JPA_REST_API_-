package com.kh.jpaHomework.member.Repository;

import com.kh.jpaHomework.member.entity.MemberEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager entityManager;

    public void join(MemberEntity entity) {
        entityManager.persist(entity);
    }

    public List<MemberEntity> memberList() {
        return entityManager
                .createQuery("SELECT m FROM MemberEntity m", MemberEntity.class)
                .getResultList();
    }
}
