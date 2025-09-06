package com.pruebatecnica.bisa.blog.services;

import com.pruebatecnica.bisa.blog.apis.CreateAuthorRequest;
import com.pruebatecnica.bisa.blog.dtos.AuthorDto;
import com.pruebatecnica.bisa.blog.entities.Author;
import com.pruebatecnica.bisa.blog.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    @Autowired
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorDto> getAllAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(author -> {
            AuthorDto dto = new AuthorDto();
            dto.setId(author.getId());
            dto.setFirstName(author.getFirstName());
            dto.setLastName(author.getLastName());
            dto.setSecondLastName(author.getSecondLastName());
            dto.setBirthday(author.getBirthday());
            dto.setResidenceCountry(author.getResidenceCountry());
            dto.setEmail(author.getEmail());
            return dto;
        }).collect(Collectors.toList());
    }

    public AuthorDto createAuthor(CreateAuthorRequest request) {
        Author author = new Author();
        author.setBirthday(request.getBirthday());
        author.setEmail(request.getEmail());
        author.setFirstName(request.getFirstName());
        author.setLastName(request.getLastName());
        author.setResidenceCountry(request.getResidenceCountry());
        author.setSecondLastName(request.getSecondLastName());
        author.setBlogs(Collections.EMPTY_LIST);
        authorRepository.save(author);

        AuthorDto response = new AuthorDto();
        response.setBirthday(author.getBirthday());
        response.setEmail(author.getEmail());
        response.setResidenceCountry(author.getResidenceCountry());
        response.setLastName(author.getLastName());
        response.setFirstName(author.getFirstName());
        response.setSecondLastName(author.getSecondLastName());
        return response;
    }
}
