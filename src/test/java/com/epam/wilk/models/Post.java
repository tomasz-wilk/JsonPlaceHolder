package com.epam.wilk.models;

import lombok.Data;

@Data
public class Post {
    public Post(Integer userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    Integer id;
    Integer userId;
    String title;
    String body;
}
