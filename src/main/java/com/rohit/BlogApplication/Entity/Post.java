package com.example.BlogApplication.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(name = "title", length = 40, nullable = false)
    private String title;

    @Column(name = "content", length = 5000, nullable = false)
    private String content;

    @Column(name = "image")
    private String imageName;

    @Column(name = "date")
    private Date publishedDate;

    @ManyToOne
    private Tags tags;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

}
