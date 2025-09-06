package com.pruebatecnica.bisa.blog.controllers;

import com.pruebatecnica.bisa.blog.apis.CreateBlogRequest;
import com.pruebatecnica.bisa.blog.dtos.AuthorDto;
import com.pruebatecnica.bisa.blog.dtos.BlogDto;
import com.pruebatecnica.bisa.blog.services.AuthorService;
import com.pruebatecnica.bisa.blog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDto>> getAllAuthors()
    {
        List<BlogDto> blogs = blogService.getAllBlogs();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @PostMapping("/createBlog")
    public ResponseEntity<BlogDto> createBlog(@RequestBody CreateBlogRequest request)
    {
        BlogDto blog = blogService.createBlog(request);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/getBlog/{blogId}")
    public ResponseEntity<BlogDto> getBlog(@PathVariable long blogId)
    {
        BlogDto blog = blogService.getBlog(blogId);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
