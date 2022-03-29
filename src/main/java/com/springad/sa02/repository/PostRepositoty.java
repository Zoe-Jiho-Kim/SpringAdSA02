package com.springad.sa02.repository;

import com.springad.sa02.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepositoty extends JpaRepository<Post, Long> {
    List<Post> findAllByUserId(Long userId);
}
