package com.pruebatecnica.bisa.blog.controllers;

import com.pruebatecnica.bisa.blog.apis.request.CreateCommentRequest;
import com.pruebatecnica.bisa.blog.dtos.CommentDto;
import com.pruebatecnica.bisa.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/createComment")
    public ResponseEntity<CommentDto> createCommentInBlog(@Valid @RequestBody CreateCommentRequest request)
    {
        CommentDto comment = commentService.createComment(request);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

}
