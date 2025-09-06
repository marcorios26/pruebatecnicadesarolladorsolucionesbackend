package com.pruebatecnica.bisa.blog.apis.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UpdateBlogRequest {

    @NotBlank(message = "Content cannot be blank")
    private String content;

    @NotBlank(message = "Periodicity cannot be blank")
    private String periodicity;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Topic cannot be blank")
    private String topic;

    private boolean allowComments;

}
