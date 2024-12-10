package com.surani.blog.services;

import com.surani.blog.models.Category;
import com.surani.blog.models.User;
import com.surani.blog.payloads.Dtos.PostDto;

import java.util.List;

public interface PostServices {
//    Create Post
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

//    Update Post
    PostDto updatePost(PostDto postDto, Integer postId);

//    Get Post by Id
    PostDto getPostById(Integer postId);

//    Delete Post
    void deletePost(Integer postId);

//    get all posts
    List<PostDto> getAllPosts(Integer pageNumber, Integer pageSize);

//    get all posts by category
    List<PostDto> getAllByCategory(Integer categoryId);

//    get all posts by user
    List<PostDto> getAllByUser(Integer userId);

//    search posts
    List<PostDto> searchPosts(String keyword);
}
