package com.surani.blog.repositorys;

import com.surani.blog.models.Category;
import com.surani.blog.models.Post;
import com.surani.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findAllByCategory(Category category);

    List<Post> findAllByUser(User user);

    List<Post> findByTitleContaining(String title);
}
