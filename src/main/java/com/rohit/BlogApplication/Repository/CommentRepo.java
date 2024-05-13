package com.rohit.BlogApplication.Repository;

import com.rohit.BlogApplication.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
