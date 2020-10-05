package com.epam.wilk.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Album {

    public Album(Integer userId, String title) {
        this.userId = userId;
        this.title = title;
    }

    Integer id;
    Integer userId;
    String title;
}
