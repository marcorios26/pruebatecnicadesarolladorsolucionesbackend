package com.pruebatecnica.bisa.blog.apis;

import lombok.Getter;
import lombok.Setter;


/**
 * @author: Marco Rios
 */
@Getter
@Setter
public class CreateCommentRequest {

    private String content;

    private String writerName;

    private String writerEmail;

    private int writerPunctuation;

    private long blogId;
}
