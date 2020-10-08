package com.epam.wilk.steps;

import com.epam.wilk.models.Post;
import org.assertj.core.api.SoftAssertions;

public class PostSteps {

    public void verifyPost(Post actualPost, Integer id, Integer userId, String title, String body) {
        var softly = new SoftAssertions();
        softly.assertThat(actualPost.getId())
                .isEqualTo(id);
        softly.assertThat(actualPost.getUserId())
                .isEqualTo(userId);
        softly.assertThat(actualPost.getTitle())
                .isEqualTo(title);
        softly.assertThat(actualPost.getBody())
                .isEqualTo(body);
        softly.assertAll();
    }

    public void verifyPost(Post actualPost, Integer id, Integer userId) {
        var softly = new SoftAssertions();
        softly.assertThat(actualPost.getId())
                .isEqualTo(id);
        softly.assertThat(actualPost.getUserId())
                .isEqualTo(userId);
        softly.assertThat(actualPost.getTitle())
                .isNotNull();
        softly.assertThat(actualPost.getBody())
                .isNotNull();
        softly.assertAll();
    }
}
