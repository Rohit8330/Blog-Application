package com.rohit.BlogApplication.Controller;

import com.rohit.BlogApplication.Payloads.ApiResponse;
import com.rohit.BlogApplication.Payloads.PostDTO;
import com.rohit.BlogApplication.Payloads.PostResponse;
import com.rohit.BlogApplication.Services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.awt.image.RescaleOp;
import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    //create
    @PostMapping("/user/{userId}/tags/{tagId}/newPost")
    public ResponseEntity<PostDTO> createPost(
            @Valid @RequestBody PostDTO postDTO,
            @PathVariable("userId") Integer userId,
            @PathVariable("tagId") Integer tagId) {
        PostDTO newPost = this.postService.createPost(postDTO, userId, tagId);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    //get
    @GetMapping("/allPosts")
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize) {
        PostResponse allPost = this.postService.getAllPost(pageNumber, pageSize);
        return new ResponseEntity<>(allPost, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable("id") Integer postId) {
        PostDTO postDTO = this.postService.getPostById(postId);
        return new ResponseEntity<>(postDTO, HttpStatus.OK);
    }

    @GetMapping("/tags/{id}")
    public ResponseEntity<List<PostDTO>> getPostsByTags(@PathVariable("id") Integer tagId) {
        List<PostDTO> postDTO = this.postService.getPostByTags(tagId);
        return new ResponseEntity<>(postDTO, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<PostDTO>> getPostsByUsers(@PathVariable("id") Integer userId) {
        List<PostDTO> postDTO = this.postService.getPostByUsers(userId);
        return new ResponseEntity<>(postDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deletePostById(@PathVariable("id") Integer postId) {
        this.postService.deletePost(postId);
        return new ResponseEntity<>(new ApiResponse("Post deleted successfully.", true), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO, @PathVariable("id") Integer postId) {
        PostDTO updatedPost = this.postService.updatePost(postDTO, postId);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    @GetMapping("search/{keyword}")
    public ResponseEntity<List<PostDTO>> searchPostByTitle(@PathVariable("keyword") String keyword) {
        List<PostDTO> postDTOS = this.postService.searchPostByTitle(keyword);
        return new ResponseEntity<>(postDTOS, HttpStatus.OK);
    }
}
