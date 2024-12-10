package com.surani.blog.controllers;

import com.surani.blog.payloads.ApiResponse;
import com.surani.blog.payloads.Dtos.PostDto;
import com.surani.blog.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PostControllers {

    private final PostServices postServices;

    @Autowired
    public PostControllers(PostServices postServices) {
        this.postServices = postServices;
    }

    @PostMapping("users/{userId}/categories/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@PathVariable Integer userId, @PathVariable Integer categoryId, @RequestBody PostDto postDto) {
        return new ResponseEntity<>(this.postServices.createPost(postDto, userId, categoryId), HttpStatus.CREATED);
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@PathVariable Integer postId, @RequestBody PostDto postDto) {
        return new ResponseEntity<>(this.postServices.updatePost(postDto, postId), HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId) {
        return new ResponseEntity<>(this.postServices.getPostById(postId), HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId) {
        this.postServices.deletePost(postId);
        return new ResponseEntity<>(new ApiResponse("Post deleted successfully"), HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPosts(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize
    ) {
        return new ResponseEntity<>(this.postServices.getAllPosts(pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getAllByCategory(@PathVariable Integer categoryId) {
        return new ResponseEntity<>(this.postServices.getAllByCategory(categoryId), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getAllByUser(@PathVariable Integer userId) {
        return new ResponseEntity<>(this.postServices.getAllByUser(userId), HttpStatus.OK);
    }

    @GetMapping("/posts/search")
    public ResponseEntity<List<PostDto>> searchPosts(@RequestParam("q") String keyword) {
        return new ResponseEntity<>(this.postServices.searchPosts(keyword), HttpStatus.OK);
    }

}
