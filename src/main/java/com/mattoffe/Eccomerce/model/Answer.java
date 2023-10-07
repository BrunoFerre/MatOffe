package com.mattoffe.Eccomerce.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    @Column(length = 500)
    private String body;
    private String userName;


}
