package com.pruebatecnica.bisa.blog.repositories;

import com.pruebatecnica.bisa.blog.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

//    List<Comment> findAllByIdBlog(long idBlog);
}
