package com.pruebatecnica.bisa.blog.services;

import com.pruebatecnica.bisa.blog.apis.CreateCommentRequest;
import com.pruebatecnica.bisa.blog.dtos.CommentDto;
import com.pruebatecnica.bisa.blog.entities.Blog;
import com.pruebatecnica.bisa.blog.entities.Comment;
import com.pruebatecnica.bisa.blog.repositories.BlogRepository;
import com.pruebatecnica.bisa.blog.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CommentService {
    @Autowired
    private final CommentRepository commentRepository;

    @Autowired
    private final BlogRepository blogRepository;
    public CommentService(CommentRepository commentRepository, BlogRepository blogRepository) {
        this.commentRepository = commentRepository;
        this.blogRepository = blogRepository;
    }

//    public List<CommentDto> getAllCommentsByIdBlog(long idBlog) {
//        return commentRepository.findAllByIdBlog(idBlog)
//                .stream()
//                .map(comment -> {
//                    CommentDto dto = new CommentDto();
//                    dto.setId(comment.getId());
//                    dto.setBlog(comment.getBlog());
//                    dto.setContent(comment.getContent());
//                    dto.setWriterName(comment.getWriterName());
//                    dto.setWriterEmail(comment.getWriterEmail());
//                    dto.setWriterPunctuation(comment.getWriterPunctuation());
//                    return dto;
//                }).collect(Collectors.toList());
//    }

    public CommentDto createComment(CreateCommentRequest request) {
        Blog blog = blogRepository.findById(request.getBlogId())
                .orElseThrow(() -> new RuntimeException("Blog not found with id " + request.getBlogId()));

        Comment comment = new Comment();
        comment.setContent(request.getContent());
        comment.setWriterName(request.getWriterName());
        comment.setWriterEmail(request.getWriterEmail());
        comment.setWriterPunctuation(request.getWriterPunctuation());
        comment.setBlog(blog);

        Comment savedComment = commentRepository.save(comment);

        if (blog.getComments() == null) {
            blog.setComments(new ArrayList<>());
        }
        blog.getComments().add(savedComment);

        CommentDto dto = new CommentDto();
        dto.setId(savedComment.getId());
        dto.setContent(savedComment.getContent());
        dto.setWriterName(savedComment.getWriterName());
        dto.setWriterEmail(savedComment.getWriterEmail());
        dto.setWriterPunctuation(savedComment.getWriterPunctuation());

        return dto;
    }

}
