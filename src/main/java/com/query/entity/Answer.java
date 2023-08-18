package com.query.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
    @Id //PK
    @GeneratedValue
    private Long id;

    //mem que bo

    @ManyToOne
    private Member member;

    //@ManyToOne
   // private Question question;


    private String body;

}
