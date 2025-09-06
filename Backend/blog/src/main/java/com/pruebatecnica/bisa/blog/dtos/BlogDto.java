package com.pruebatecnica.bisa.blog.dtos;

import com.pruebatecnica.bisa.blog.entities.Author;
import com.pruebatecnica.bisa.blog.entities.Comment;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BlogDto {

    private long id;

    private String content;

    private boolean allowComments;

    private Author author;

    private String periodicity;

    private String title;

    private String topic;

    private List<Comment> comments;
}
