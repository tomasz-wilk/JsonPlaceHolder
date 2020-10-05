package com.epam.wilk.tests;


import com.epam.wilk.endpoints.PostEndpoint;
import com.epam.wilk.models.Post;
import com.epam.wilk.steps.PostSteps;
import com.epam.wilk.utils.JsonConverter;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Verify all posts")
    public void verifyAllPosts() {
        var response = postEndpoint.getPosts();

        assertThat(response.getStatusCode())
                .as("wrong status code")
                .isEqualTo(HttpStatus.SC_OK);

        var posts = Arrays.asList(JsonConverter.convertToJson(response, Post[].class));
        assertThat(posts.size()).isEqualTo(100);
    }

    @Test
    @DisplayName("Verify single post")
    public void verifyPost() {
        var response = postEndpoint.getPost(TEST_POST_ID);

        assertThat(response.getStatusCode())
                .as("wrong status code")
                .isEqualTo(HttpStatus.SC_OK);

        var post = JsonConverter.convertToJson(response, Post.class);

        postSteps.verifyPost(post, TEST_POST_ID, 5);
    }

    @Test
    @DisplayName("Verify adding post")
    public void verifyAddPost() {
        var userId = 6;
        var testTitle = "test title";
        var testBody = "test body";

        var response = postEndpoint.addPost(userId, testTitle, testBody);

        assertThat(response.getStatusCode())
                .as("wrong status code")
                .isEqualTo(HttpStatus.SC_CREATED);

        var post = JsonConverter.convertToJson(response, Post.class);
        postSteps.verifyPost(post, 101, userId, testTitle, testBody);
    }

    @Test
    @DisplayName("Verify updating post")
    public void verifyUpdatePost() {
        var userId = 6;
        var testTitle = "test title";
        var testBody = "test body";

        var response = postEndpoint.updatePost(TEST_POST_ID, userId, testTitle, testBody);

        assertThat(response.getStatusCode())
                .as("wrong status code")
                .isEqualTo(HttpStatus.SC_OK);

        var post = JsonConverter.convertToJson(response, Post.class);
        postSteps.verifyPost(post, TEST_POST_ID, userId, testTitle, testBody);
    }

    @Test
    @DisplayName("Verify deleting post")
    public void verifyDeletePost() {
        var response = postEndpoint.deletePost(TEST_POST_ID);

        assertThat(response.getStatusCode())
                .as("wrong status code")
                .isEqualTo(HttpStatus.SC_OK);
    }
}
