package com.pruebatecnica.bisa.blog.controllers;

import com.pruebatecnica.bisa.blog.apis.request.CreateBlogRequest;
import com.pruebatecnica.bisa.blog.apis.request.UpdateBlogRequest;
import com.pruebatecnica.bisa.blog.dtos.BlogDto;
import com.pruebatecnica.bisa.blog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
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
    public ResponseEntity<BlogDto> createBlog(@Valid @RequestBody CreateBlogRequest request)
    {
        BlogDto blog = blogService.createBlog(request);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/getBlog/{blogId}")
    public ResponseEntity<BlogDto> getBlog(@Valid @PathVariable long blogId)
    {
        BlogDto blog = blogService.getBlog(blogId);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PutMapping("/updateBlog/{blogId}")
    public ResponseEntity<BlogDto> updateBlog(@Valid @PathVariable long blogId, @RequestBody UpdateBlogRequest request)
    {
        BlogDto blog = blogService.updateBlog(blogId, request);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
