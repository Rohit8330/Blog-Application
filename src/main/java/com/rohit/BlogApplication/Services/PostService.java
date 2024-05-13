package com.example.BlogApplication.Services;

import com.example.BlogApplication.Entity.Post;
import com.example.BlogApplication.Payloads.PostDTO;
import com.example.BlogApplication.Payloads.PostResponse;
import com.example.BlogApplication.Payloads.TagsDTO;

import java.util.List;

public interface PostService {

    PostDTO createPost(PostDTO postDTO, Integer userId, Integer tagId);

    PostDTO updatePost(PostDTO postDTO, Integer postId);

    void deletePost(Integer postId);

    PostResponse getAllPost(Integer pageNumber, Integer pageSize);

    PostDTO getPostById(Integer postId);

    List<PostDTO> getPostByTags(Integer tagId);

    List<PostDTO> getPostByUsers(Integer userId);

    List<PostDTO> searchPostByTitle(String keyword);
}
