package com.epam.wilk.tests;


import com.epam.wilk.endpoints.PostEndpoint;
import com.epam.wilk.models.Post;
import com.epam.wilk.steps.PostSteps;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class PostIT extends BaseIT {

    private static int TEST_POST_ID = 50;

    @Autowired
    private PostSteps postSteps;

    @Autowired
    private PostEndpoint postEndpoint;


    @Test
    @DisplayName("Verify all posts")
    public void verifyAllPosts(TestInfo testInfo) {
        var response = postEndpoint.getPosts();

        assertThat(response.getStatusCode())
                .as("wrong status code")
                .isEqualTo(HttpStatus.SC_OK);

        var posts = Arrays.asList(new Gson().fromJson(response.jsonPath().prettify(), Post[].class));
        assertThat(posts.size()).isEqualTo(100);
    }

    @Test
    @DisplayName("Verify single post")
    public void verifyPost(TestInfo testInfo) {
        var response = postEndpoint.getPost(TEST_POST_ID);

        assertThat(response.getStatusCode())
                .as("wrong status code")
                .isEqualTo(HttpStatus.SC_OK);

        var post = new Gson().fromJson(response.jsonPath().prettify(), Post.class);
        postSteps.verifyPost(post, TEST_POST_ID, 5);
    }

    @Test
    @DisplayName("Verify adding post")
    public void verifyAddPost(TestInfo testInfo) {
        var userId = 6;
        var testTitle = "test title";
        var testBody = "test body";

        var response = postEndpoint.addPost(userId, testTitle, testBody);

        assertThat(response.getStatusCode())
                .as("wrong status code")
                .isEqualTo(HttpStatus.SC_CREATED);

        var post = new Gson().fromJson(response.jsonPath().prettify(), Post.class);
        postSteps.verifyPost(post, 101, userId, testTitle, testBody);
    }
}
