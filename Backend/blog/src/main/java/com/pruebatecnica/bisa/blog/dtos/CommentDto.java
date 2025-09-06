package com.pruebatecnica.bisa.blog.dtos;

import com.pruebatecnica.bisa.blog.entities.Blog;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
public class CommentDto {

    private long id;

    private String content;

    private String writerName;

    private String writerEmail;

    private int writerPunctuation;

    private Blog blog;
}
