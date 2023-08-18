package com.query.dto;

import com.query.entity.Member;
import com.query.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionViewResponse {
    private Long id;
    private String body;
    private Long ownerId;
    private Long writerId;
    private LocalDateTime createdDate;

    public QuestionViewResponse(Question question) {
        this.id = question.getId();
        this.body = question.getBody();
        this.ownerId = question.getOwner().getMemberId();
        this.writerId = question.getWriter().getMemberId();
        this.createdDate = question.getCreatedDate();
    }
}
