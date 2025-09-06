package com.pruebatecnica.bisa.blog.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "blog_history")
public class BlogHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long blogId;

    @NotBlank
    private String title;

    @NotBlank
    private String topic;

    @NotBlank
    private String content;

    private boolean allowComments;

    @NotBlank
    private String periodicity;

    private LocalDateTime updatedAt;
}
