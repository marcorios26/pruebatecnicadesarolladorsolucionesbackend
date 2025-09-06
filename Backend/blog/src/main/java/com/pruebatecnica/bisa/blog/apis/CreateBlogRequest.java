package com.pruebatecnica.bisa.blog.apis;

import com.pruebatecnica.bisa.blog.entities.Author;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author: Marco Rios
 */
@Getter
@Setter
public class CreateBlogRequest {
    @NotBlank
    private long authorId;

    @NotBlank
    private String content;

    @NotBlank
    private String periodicity;

    @NotBlank
    private String title;

    @NotBlank
    private String topic;

    @NotBlank
    private boolean allowComments;

    public boolean isAllowComments() {
        return allowComments;
    }

    public void setAllowComments(boolean allowComments) {
        this.allowComments = allowComments;
    }

}
