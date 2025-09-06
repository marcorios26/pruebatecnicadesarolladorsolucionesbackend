package com.pruebatecnica.bisa.blog.apis.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;


/**
 * @author: Marco Rios
 */
@Getter
@Setter
public class CreateCommentRequest {

    @NotBlank(message = "Content is required")
    private String content;

    @NotBlank(message = "Writer name is required")
    private String writerName;

    @NotBlank(message = "Writer email is required")
    @Email(message = "Invalid email format")
    private String writerEmail;

    @Min(value = 0, message = "Punctuation must be between 0 and 10")
    @Max(value = 10, message = "Punctuation must be between 0 and 10")
    private int writerPunctuation;

    @NotNull(message = "Blog ID is required")
    @Positive(message = "Blog ID must be greater than 0")
    private Long blogId;
}
