package com.rohit.BlogApplication.Services;

import com.rohit.BlogApplication.Entity.Post;
import com.rohit.BlogApplication.Payloads.PostDTO;
import com.rohit.BlogApplication.Payloads.PostResponse;
import com.rohit.BlogApplication.Payloads.TagsDTO;

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
