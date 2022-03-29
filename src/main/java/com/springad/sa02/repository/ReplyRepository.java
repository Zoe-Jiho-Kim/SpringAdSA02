package com.springad.sa02.repository;

import com.springad.sa02.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findAllByUserId(Long userId);
}
