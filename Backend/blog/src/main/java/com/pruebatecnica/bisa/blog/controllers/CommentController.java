package com.pruebatecnica.bisa.blog.controllers;

import com.pruebatecnica.bisa.blog.apis.CreateCommentRequest;
import com.pruebatecnica.bisa.blog.dtos.CommentDto;
import com.pruebatecnica.bisa.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

//    @GetMapping("/comments/{idBlog}")
//    public ResponseEntity<List<CommentDto>> getAllCommentsByIdBlog(@PathVariable final long idBlog)
//    {
//        List<CommentDto> comments = commentService.getAllCommentsByIdBlog(idBlog);
//        return new ResponseEntity<>(comments, HttpStatus.OK);
//    }

    @PostMapping("/createComment")
    public ResponseEntity<CommentDto> createCommentInBlog(@RequestBody CreateCommentRequest request)
    {
        CommentDto comment = commentService.createComment(request);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

}
