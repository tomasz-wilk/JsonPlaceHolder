package com.epam.wilk.tests;


import com.epam.wilk.endpoints.PostEndpoint;
import com.epam.wilk.models.Post;
import com.epam.wilk.steps.PostSteps;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
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
    public void verifyAllPosts() {
        var response = postEndpoint.getPosts();

        assertThat(response.getStatusCode())
                .as("wrong status code")
                .isEqualTo(HttpStatus.SC_OK);

        var posts = Arrays.asList(new Gson().fromJson(response.jsonPath().prettify(), Post[].class));
        assertThat(posts.size()).isEqualTo(100);
    }

    @Test
    public void verifyPost() {
        var response = postEndpoint.getPost(TEST_POST_ID);

        assertThat(response.getStatusCode())
                .as("wrong status code")
                .isEqualTo(HttpStatus.SC_OK);

        var post = new Gson().fromJson(response.jsonPath().prettify(), Post.class);
        postSteps.verifyPost(post, TEST_POST_ID, 5);
    }

    @Test
    public void verifyAddPost() {
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
