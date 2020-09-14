package com.epam.wilk.endpoints;

import com.epam.wilk.configuration.TestProperties;
import com.epam.wilk.models.Post;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostEndpoint {

    @NonNull
    private String baseUrl;

    @NonNull
    private TestProperties testProperties;

    private static String POST_URI = "posts/";
    private static Gson GSON = new Gson();

    public Response getPost(int postId) {
        return given()
                .get(POST_URI + postId)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    public Response getPosts() {
        return given()
                .get(POST_URI)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    public Response addPost(int userId, String title, String body) {
        var post = new Post(userId, title, body);
        var requestBody = GSON.toJson(post);
        return given()
                .body(requestBody)
                .post(POST_URI)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    public Response updatePost(int id, int userId, String title, String body) {
        var post = new Post(id, userId, title, body);
        var requestBody = GSON.toJson(post);
        return given()
                .body(requestBody)
                .put(POST_URI + id)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    public Response deletePost(int id) {
        return given()
                .delete(POST_URI + id)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    private RequestSpecification given() {
        return RestAssured.given().baseUri(baseUrl).port(-1).log().all().contentType(ContentType.JSON);
    }
}
