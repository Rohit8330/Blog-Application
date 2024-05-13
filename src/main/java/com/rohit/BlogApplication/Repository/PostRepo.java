package com.example.BlogApplication.Repository;

import com.example.BlogApplication.Entity.Post;
import com.example.BlogApplication.Entity.Tags;
import com.example.BlogApplication.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByTags(Tags tags);
    List<Post> findByUser(User user);

    List<Post> findByTitleContaining(String title);
}
