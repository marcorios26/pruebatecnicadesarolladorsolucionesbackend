package com.pruebatecnica.bisa.blog.apis;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBlogRequest {
    private String content;
    private boolean allowComments;
    private String periodicity;
    private String title;
    private String topic;
}
