package com.query.controller;

import com.query.dto.AnswerRequestDTO;
import com.query.dto.AnswerResponseDTO;
import com.query.entity.Member;
import com.query.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("answer")
@CrossOrigin(origins = "*")

public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping()
    public ResponseEntity createAnswer(@AuthenticationPrincipal Member member, @RequestBody AnswerRequestDTO request) {
        Long answerId = answerService.answerCreate(member, request);

        return new ResponseEntity<>(answerId, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity getAnswer(@RequestParam Long questionId) {
        List<AnswerResponseDTO> response = answerService.answerGet(questionId);
        return new ResponseEntity(response, HttpStatus.ACCEPTED);
    }
}
