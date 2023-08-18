package com.query.repository;

import com.query.entity.Answer;
import com.query.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer,Long> {

    List<Answer> findAllByQuestion(Question question);
}
