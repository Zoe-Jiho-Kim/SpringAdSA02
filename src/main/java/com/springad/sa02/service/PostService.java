package com.springad.sa02.service;

import com.springad.sa02.dto.PostRequestDto;
import com.springad.sa02.model.Post;
import com.springad.sa02.repository.PostRepositoty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepositoty postRepositoty;

    @Autowired
    public PostService(PostRepositoty postRepositoty) {
        this.postRepositoty = postRepositoty;
    }


    public Post createPost(PostRequestDto postRequestDto, String username, Long userId){
        Post post = new Post(postRequestDto, username, userId);
        postRepositoty.save(post);
        return post;
    }

    public Long updatePost(Long id, PostRequestDto postRequestDto) {
        Post post = postRepositoty.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다")
        );
        post.update(postRequestDto);
        return post.getId();
    }
}
