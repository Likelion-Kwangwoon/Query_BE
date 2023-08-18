package com.query.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerResponseDTO {

    private Long answerId;

    private Long writerId;

    private String body;

}
