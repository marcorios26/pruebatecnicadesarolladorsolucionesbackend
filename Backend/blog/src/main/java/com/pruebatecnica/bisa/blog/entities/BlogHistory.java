package com.pruebatecnica.bisa.blog.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "blog_history")
public class BlogHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long blogId;

    private String title;
    private String topic;
    private String content;
    private boolean allowComments;
    private String periodicity;

    private LocalDateTime updatedAt;
}
