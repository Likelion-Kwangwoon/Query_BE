package com.query.controller;

import com.query.entity.Member;
import com.query.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("member")

public class MemberController {
//@AuthenticationPrincipal Member member

    @Autowired
    private MemberRepository memberRepository;
    @GetMapping("")
    public ResponseEntity allMember(@AuthenticationPrincipal Member member) {

        List<Member> memberList = memberRepository.findAll();
        return new ResponseEntity<>(memberList, HttpStatus.ACCEPTED);
    }
}
