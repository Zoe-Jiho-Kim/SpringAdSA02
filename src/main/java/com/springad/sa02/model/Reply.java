package com.springad.sa02.model;

import com.springad.sa02.dto.ReplyRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Reply extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private Long userId;

    public Reply(ReplyRequestDto replyRequestDto, String username, Long userId) {
        this.username = username;
        this.contents = replyRequestDto.getContents();
        this.userId = userId;
    }
}
