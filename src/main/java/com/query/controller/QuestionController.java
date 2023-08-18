package com.query.controller;

import com.query.dto.QuestionCreateRequest;
import com.query.dto.QuestionViewRequest;
import com.query.dto.QuestionViewResponse;
import com.query.entity.Member;
import com.query.entity.Question;
import com.query.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    // 질문 작성
    @PostMapping("/{email}")
    public ResponseEntity<Void> addQuestion(@AuthenticationPrincipal Member writer, @RequestBody QuestionCreateRequest dto) {
        questionService.createQuestion(writer, dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // 페이지 주인이 올린 질문 조회
    @GetMapping("/{email}/my")
    public ResponseEntity<List<QuestionViewResponse>> getMyQuestion(@PathVariable String email) {
        List<QuestionViewResponse> questions = questionService.getMyQuestion(email)
                .stream()
                .map(QuestionViewResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(questions);
    }

    // 다른 사람들이 남긴 질문 조회
    @GetMapping("/{email}/other")
    public ResponseEntity<List<QuestionViewResponse>> getOtherQuestion(@PathVariable String email) {
        List<QuestionViewResponse> questions = questionService.getOtherQuestion(email)
                .stream()
                .map(QuestionViewResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(questions);
    }

}
