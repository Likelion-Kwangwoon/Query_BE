package com.query.controller;

import com.query.entity.Member;
import com.query.entity.Question;
import com.query.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class QuestionController {
    //@AuthenticationPrincipal Member member
    @Autowired
    QuestionService questionService;


//    @PostMapping("/api/articles")
//    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request
//            , Principal principal) {
//        Article savedArticle = blogService.save(request, principal.getName());
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
//        // 응답 코드로 201, created를 응답하고 테이블에 저장된 객체를 반환
//    }

    @PostMapping("/{email}")
    public ResponseEntity<Void> addQuestion(@PathVariable String ownerEmail, @AuthenticationPrincipal Member writer) {

    }

}
