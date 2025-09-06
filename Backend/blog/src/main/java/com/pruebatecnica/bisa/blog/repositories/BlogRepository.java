package com.pruebatecnica.bisa.blog.repositories;

import com.pruebatecnica.bisa.blog.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

}
