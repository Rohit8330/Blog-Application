package com.rohit.BlogApplication.Repository;

import com.rohit.BlogApplication.Entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepo extends JpaRepository<Tags, Integer> {
}
