package com.example.BlogApplication.Repository;

import com.example.BlogApplication.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
