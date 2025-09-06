package com.pruebatecnica.bisa.blog.controllers;

import com.pruebatecnica.bisa.blog.apis.CreateAuthorRequest;
import com.pruebatecnica.bisa.blog.dtos.AuthorDto;
import com.pruebatecnica.bisa.blog.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/authors")
    public ResponseEntity<List<AuthorDto>> getAllAuthors()
    {
        List<AuthorDto> authors = authorService.getAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @PostMapping("/createAuthor")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody CreateAuthorRequest request)
    {
        AuthorDto authors = authorService.createAuthor(request);
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }
}
