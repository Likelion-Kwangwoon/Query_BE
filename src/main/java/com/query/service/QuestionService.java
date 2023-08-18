package com.query.service;

import com.query.dto.QuestionCreateRequest;
import com.query.dto.QuestionViewRequest;
import com.query.entity.Member;
import com.query.entity.Question;
import com.query.repository.MemberRepository;
import com.query.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    MemberRepository memberRepository;

    // 사용자별 질문 조회
    public List<Question> getQuestion(Long memberId) {
        Member member = memberRepository.findById(memberId).get();
        return questionRepository.findByOwer(member);
    }

    // 사용자별 받은 질문 조회
//    public List<Question> getOtherQuestion(QuestionViewRequest dto) {
//        Member owner = memberRepository.findById(dto.getOwnerId()).get();
//        Member writer = memberRepository.findById(dto.getWriterId()).get();
//        return questionRepository.findByOwnerAndWriter(owner, writer);
//    }

    // 질문 작성
    public void createQuestion(QuestionCreateRequest dto) {
        Member owner = memberRepository.findById(dto.getOwnerId()).get();
        Member writer = memberRepository.findById(dto.getWriterId()).get();
        Question question = Question.builder().body(dto.getBody())
                        .owner(owner).writer(writer).build();
        questionRepository.save(question);
    }

    // 질문 삭제
    public void deleteQuestion(Long id) {
        Question question = questionRepository.findById(id).get();
        questionRepository.delete(question);
    }


}
