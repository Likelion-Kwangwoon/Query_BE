package com.query.service;

import com.query.dto.QuestionCreateRequest;
import com.query.dto.QuestionViewRequest;
import com.query.entity.Member;
import com.query.entity.Question;
import com.query.repository.MemberRepository;
import com.query.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    MemberRepository memberRepository;

    // 사용자별 본인이 남긴 질문 조회
    public List<Question> getMyQuestion(String email) {
        Member member = memberRepository.findByEmail(email).get();
        return questionRepository.findByOwnerAndWriter(member, member);
    }

    // 사용자별 받은 질문 조회
    public List<Question> getOtherQuestion(String email) {
        Member owner = memberRepository.findByEmail(email).get();
        List<Question> questions = questionRepository.findByOwner(owner);
        List<Question> returnQuestion = new ArrayList<>();
        for (Question q : questions) {
            if (q.getWriter() != owner) { // 다른 사람이 남긴 질문만 리턴하도록
                returnQuestion.add(q);
            }
        }
        return returnQuestion;
    }

    // 질문 작성
    public void createQuestion(Member writer, QuestionCreateRequest dto) {
        Member owner = memberRepository.findByEmail(dto.getOwnerEmail()).get();
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
