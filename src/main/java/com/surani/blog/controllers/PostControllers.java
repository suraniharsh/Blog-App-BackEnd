package com.surani.blog.controllers;

import com.surani.blog.payloads.Dtos.PostDto;
import com.surani.blog.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        {
            return new ResponseEntity<>(this.postServices.createPost(postDto, userId, categoryId), HttpStatus.CREATED);
        }

    }
}
