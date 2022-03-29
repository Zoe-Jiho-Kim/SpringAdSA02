package com.springad.sa02.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String emil;

    @Column(nullable = false)
    private Long kakaoId;

    public User(String username, String password, String emil) {
        this.username = username;
        this.password = password;
        this.emil = emil;
    }

    public User(String username, String password, String emil, Long kakaoId) {
        this.username = username;
        this.password = password;
        this.emil = emil;
        this.kakaoId = kakaoId;
    }
}
