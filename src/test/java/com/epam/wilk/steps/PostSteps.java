package com.epam.wilk.steps;

import com.epam.wilk.models.Post;
import org.assertj.core.api.AutoCloseableSoftAssertions;
import org.springframework.stereotype.Component;

@Component
public class PostSteps {

    public void verifyPost(Post actualPost, Integer id, Integer userId, String title, String body){
        try (AutoCloseableSoftAssertions softly = new AutoCloseableSoftAssertions()) {
            softly.assertThat(actualPost.getId())
                    .isEqualTo(id);
            softly.assertThat(actualPost.getUserId())
                    .isEqualTo(userId);
            softly.assertThat(actualPost.getTitle())
                    .isEqualTo(title);
            softly.assertThat(actualPost.getBody())
                    .isEqualTo(body);
        }
    }

    public void verifyPost(Post actualPost, Integer id, Integer userId){
        try (AutoCloseableSoftAssertions softly = new AutoCloseableSoftAssertions()) {
            softly.assertThat(actualPost.getId())
                    .isEqualTo(id);
            softly.assertThat(actualPost.getUserId())
                    .isEqualTo(userId);
            softly.assertThat(actualPost.getTitle())
                    .isNotNull();
            softly.assertThat(actualPost.getBody())
                    .isNotNull();
        }
    }

}
