package com.surani.blog.services.Impl;

import com.surani.blog.exceptions.ResourceNotFoundException;
import com.surani.blog.models.Category;
import com.surani.blog.models.Post;
import com.surani.blog.models.User;
import com.surani.blog.payloads.Dtos.PostDto;
import com.surani.blog.repositorys.CategoryRepo;
import com.surani.blog.repositorys.PostRepo;
import com.surani.blog.repositorys.UserRepo;
import com.surani.blog.services.PostServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServicesImpl implements PostServices {

    private final PostRepo postRepo;
    private final CategoryRepo categoryRepo;
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public PostServicesImpl(PostRepo postRepo, CategoryRepo categoryRepo, UserRepo userRepo, ModelMapper modelMapper) {
        this.postRepo = postRepo;
        this.categoryRepo = categoryRepo;
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId)));
        post.setCategory(this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId)));

        return this.modelMapper.map(this.postRepo.save(post), PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<PostDto> getAllPosts() {
        return List.of();
    }

    @Override
    public List<PostDto> getAllByCategory(Category category) {
        return List.of();
    }

    @Override
    public List<PostDto> getAllByUser(User user) {
        return List.of();
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        return List.of();
    }
}
