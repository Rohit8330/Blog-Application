package com.example.BlogApplication.Services.Impl;

import com.example.BlogApplication.Entity.Post;
import com.example.BlogApplication.Entity.Tags;
import com.example.BlogApplication.Entity.User;
import com.example.BlogApplication.Exceptions.ResourceNotFoundException;
import com.example.BlogApplication.Payloads.PostDTO;
import com.example.BlogApplication.Payloads.PostResponse;
import com.example.BlogApplication.Repository.PostRepo;
import com.example.BlogApplication.Repository.TagsRepo;
import com.example.BlogApplication.Repository.UserRepo;
import com.example.BlogApplication.Services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TagsRepo tagsRepo;

    @Override
    public PostDTO createPost(PostDTO postDTO, Integer userId, Integer tagId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
        Tags tags = this.tagsRepo.findById(tagId).orElseThrow(()-> new ResourceNotFoundException("Tags", "Id", tagId));

        Post post = this.modelMapper.map(postDTO, Post.class);
        post.setImageName("default.png");
        post.setPublishedDate(new Date());
        post.setTags(tags);
        post.setUser(user);

        Post newPost = this.postRepo.save(post);

        return this.modelMapper.map(newPost, PostDTO.class);
    }

    @Override
    public PostResponse getAllPost(Integer pageNumber, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Post> page = this.postRepo.findAll(pageable);
        List<PostDTO> postDTOS = page.getContent().stream().map(post -> this.modelMapper.map(post, PostDTO.class)).toList();

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDTOS);
        postResponse.setPageNumber(page.getNumber());
        postResponse.setPageSize(page.getSize());
        postResponse.setTotalElements(page.getNumberOfElements());
        postResponse.setTotalPages(page.getTotalPages());
        postResponse.setLastPage(page.isLast());

        return postResponse;
    }

    @Override
    public PostDTO getPostById(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));

        return this.modelMapper.map(post, PostDTO.class);
    }

    @Override
    public List<PostDTO> getPostByTags(Integer tagId) {
        Tags tags = this.tagsRepo.findById(tagId).orElseThrow(()-> new ResourceNotFoundException("Tag", "Id", tagId));
        List<Post> posts = this.postRepo.findByTags(tags);

        return posts.stream().map(post -> this.modelMapper.map(post, PostDTO.class)).toList();
    }

    @Override
    public List<PostDTO> getPostByUsers(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        List<Post> posts = this.postRepo.findByUser(user);

        return posts.stream().map(post -> this.modelMapper.map(post, PostDTO.class)).toList();
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));

        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setImageName(postDTO.getImageName());
        post.setPublishedDate(postDTO.getPublishedDate());

        Post updatedPost = this.postRepo.save(post);

        return this.modelMapper.map(updatedPost, PostDTO.class);

    }

    @Override
    public void deletePost(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));

        this.postRepo.delete(post);
    }

    @Override
    public List<PostDTO> searchPostByTitle(String keyword) {
        List<Post> posts = this.postRepo.findByTitleContaining(keyword);

        return posts.stream().map(post -> this.modelMapper.map(post, PostDTO.class)).toList();
    }
}
