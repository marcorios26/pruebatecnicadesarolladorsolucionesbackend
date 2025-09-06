package com.pruebatecnica.bisa.blog.services;

import com.pruebatecnica.bisa.blog.apis.CreateBlogRequest;
import com.pruebatecnica.bisa.blog.dtos.BlogDto;
import com.pruebatecnica.bisa.blog.entities.Author;
import com.pruebatecnica.bisa.blog.entities.Blog;
import com.pruebatecnica.bisa.blog.repositories.AuthorRepository;
import com.pruebatecnica.bisa.blog.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {
    @Autowired
    private final BlogRepository blogRepository;
    @Autowired
    private final AuthorRepository authorRepository;


    public BlogService(BlogRepository blogRepository, AuthorRepository authorRepository) {
        this.blogRepository = blogRepository;
        this.authorRepository = authorRepository;
    }

    public List<BlogDto> getAllBlogs() {
        return blogRepository.findAll()
                .stream()
                .map(blog -> {
                    BlogDto dto = new BlogDto();
                    dto.setId(blog.getId());
                   dto.setAuthor(blog.getAuthor());
                   dto.setContent(blog.getContent());
                    return dto;
                }).collect(Collectors.toList());
    }

    public BlogDto createBlog(CreateBlogRequest request){

        Author author = authorRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Blog newBlog = new Blog();
        newBlog.setAuthor(author);
        newBlog.setContent(request.getContent());
        newBlog.setAllowComments(request.isAllowComments());
        newBlog.setTitle(request.getTitle());
        newBlog.setTopic(request.getTopic());
        newBlog.setPeriodicity(request.getPeriodicity());

        Blog savedBlog = blogRepository.save(newBlog);

        BlogDto blogDto = new BlogDto();
        blogDto.setId(savedBlog.getId());
        blogDto.setAuthor(savedBlog.getAuthor());
        blogDto.setContent(savedBlog.getContent());
        blogDto.setAllowComments(savedBlog.isAllowComments());
        blogDto.setTitle(savedBlog.getTitle());
        blogDto.setTopic(savedBlog.getTopic());
        blogDto.setPeriodicity(savedBlog.getPeriodicity());
        blogDto.setComments(new ArrayList<>());
        return blogDto;
    }

    public BlogDto getBlog(long blogId) {
        return blogRepository.findById(blogId)
                .map(blog -> {
                    BlogDto dto = new BlogDto();
                    dto.setId(blog.getId());
                    dto.setAuthor(blog.getAuthor());
                    dto.setTitle(blog.getTitle());
                    dto.setTopic(blog.getTopic());
                    dto.setPeriodicity(blog.getPeriodicity());
                    dto.setComments(blog.getComments());
                    dto.setAllowComments(blog.isAllowComments());
                    dto.setContent(blog.getContent());
                    return dto;
                })
                .orElseThrow(() -> new RuntimeException("Blog not found with id " + blogId));
    }
}
