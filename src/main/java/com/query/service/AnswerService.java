package com.query.service;

import com.query.dto.AnswerRequestDTO;
import com.query.dto.AnswerResponseDTO;
import com.query.entity.Answer;
import com.query.entity.Member;
import com.query.entity.Question;
import com.query.repository.AnswerRepository;
import com.query.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;


    public Long answerCreate(Member member, AnswerRequestDTO request) {

        Answer answer = request.toEntity(member);

        //question
        answerRepository.save(answer);
        return answer.getId();
    }
//articles.stream()
//        .map(article -> ArticleDTO.Response.builder()
//            .id(article.getId())
//            .title(article.getTitle())
//            .body(article.getBody())
//            .build())
//            .collect(Collectors.toList()));

    public List<AnswerResponseDTO> answerGet(Long questionId) {
        Question question = questionRepository.findById(questionId).get();
        List<Answer> answers= answerRepository.findAllByQuestion(question);
        return answers.stream()
                .map(answer -> AnswerResponseDTO.builder()
                        .answerId(answer.getId())
                        .body(answer.getBody())
                        .writerId(answer.getWriter().getMemberId())
                        .build())
                .collect(Collectors.toList());
    }
}
