package com.surani.blog.repositorys;

import com.surani.blog.models.Category;
import com.surani.blog.models.Post;
import com.surani.blog.models.User;
import com.surani.blog.payloads.Dtos.CategoryDto;
import com.surani.blog.payloads.Dtos.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<PostDto> getAllByUser(User user);

    List<PostDto> getAllByCategory(Category category);

}
