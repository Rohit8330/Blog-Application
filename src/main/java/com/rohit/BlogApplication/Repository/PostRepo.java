package com.rohit.BlogApplication.Repository;

import com.rohit.BlogApplication.Entity.Post;
import com.rohit.BlogApplication.Entity.Tags;
import com.rohit.BlogApplication.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByTags(Tags tags);
    List<Post> findByUser(User user);

    List<Post> findByTitleContaining(String title);
}
