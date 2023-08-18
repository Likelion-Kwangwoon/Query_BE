package com.query.dto;

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
    private Long body;
    private Long ownerId;
    private Long writeId;
    private LocalDateTime createdDate;
}
