package com.springad.sa02.service;

import com.springad.sa02.dto.ReplyRequestDto;
import com.springad.sa02.model.Reply;
import com.springad.sa02.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {
    private final ReplyRepository replyRepository;

    @Autowired
    public ReplyService(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }


    public Reply createReply(ReplyRequestDto replyRequestDto,String username, Long userId){
        Reply reply = new Reply(replyRequestDto, username, userId);
        replyRepository.save(reply);
        return reply;
    }

}
