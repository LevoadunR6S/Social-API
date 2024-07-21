package com.example.soc.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



    @Column(nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post task;
}
