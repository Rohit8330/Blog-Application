package com.example.BlogApplication.Repository;

import com.example.BlogApplication.Entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepo extends JpaRepository<Tags, Integer> {
}
