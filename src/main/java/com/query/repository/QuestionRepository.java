package com.query.repository;

import com.query.entity.Member;
import com.query.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    // 내가 작성한 질문 보기
    List<Question> findByOwnerAndWriter(Member owner, Member writer);
    List<Question> findByOwer(Member owner);
}
