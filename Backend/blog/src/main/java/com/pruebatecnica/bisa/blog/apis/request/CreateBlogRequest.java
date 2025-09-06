package com.pruebatecnica.bisa.blog.apis.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author: Marco Rios
 */
@Getter
@Setter
public class CreateBlogRequest {
    @NotNull(message = "Author ID is required")
    private long authorId;

    @NotBlank(message = "Content is required")
    private String content;

    @NotBlank(message = "Periodicity is required")
    private String periodicity;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Topic is required")
    private String topic;

    private boolean allowComments;

    public boolean isAllowComments() {
        return allowComments;
    }

    public void setAllowComments(boolean allowComments) {
        this.allowComments = allowComments;
    }

}
