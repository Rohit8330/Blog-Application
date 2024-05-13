package com.example.BlogApplication.Payloads;

import com.example.BlogApplication.Entity.Post;
import com.example.BlogApplication.Entity.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CommentDTO {

    private Integer commentId;

    private String content;

    private Post post;

    private User user;

    private boolean isEdited;
}
