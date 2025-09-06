package com.pruebatecnica.bisa.blog.repositories;

import com.pruebatecnica.bisa.blog.entities.BlogHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogHistoryRepository extends JpaRepository<BlogHistory, Long> {
    List<BlogHistory> findByBlogIdOrderByUpdatedAtDesc(Long blogId);
}
