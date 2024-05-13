package com.example.BlogApplication.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Comments")
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @Column(name = "content", length = 5000, nullable = false)
    private String content;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;

    private boolean isEdited = false;
}
