package com.springad.sa02.controller;

import com.springad.sa02.dto.PostRequestDto;
import com.springad.sa02.model.Post;
import com.springad.sa02.repository.PostRepositoty;
import com.springad.sa02.security.UserDetailsImpl;
import com.springad.sa02.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepositoty postRepositoty;
    private final PostService postService;

    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto postRequestDto,  @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 로그인 되어 있는 회원 테이블의 ID
        Long userId = userDetails.getUser().getId();

        Post post = postService.createPost(postRequestDto, userDetails.getUsername(), userId);

        // 응답 보내기
        return postRepositoty.save(post);
    }


}
