package com.query.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Answer {
    @Id //PK
    @GeneratedValue
    private Long id;

    //mem que bo

    @ManyToOne
    private Member writer;

    @ManyToOne
    private Question question;


    private String body;

}
