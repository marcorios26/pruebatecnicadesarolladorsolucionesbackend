package com.pruebatecnica.bisa.blog.repositories;

import com.pruebatecnica.bisa.blog.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
