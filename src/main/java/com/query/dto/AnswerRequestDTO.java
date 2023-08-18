package com.query.dto;

import com.query.entity.Answer;
import com.query.entity.Member;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerRequestDTO {


    private Long questionId;
    private String body;

    public Answer toEntity(Member member) {
        return Answer.builder()
                .writer(member)
                .body(body)
                .build();
    }
}
