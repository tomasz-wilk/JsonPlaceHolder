package com.epam.wilk.endpoints;

import com.epam.wilk.configuration.TestProperties;
import com.epam.wilk.models.Album;
import com.google.inject.Inject;
import io.restassured.response.Response;
import lombok.NonNull;

public class AlbumEndpoint extends BaseEndpoint {
    private static String ALBUM_URI = "albums/";

    @Inject
    public AlbumEndpoint(@NonNull TestProperties testProperties) {
        super(testProperties);
    }

    public Response getAlbum(int albumId) {
        return given()
                .get(ALBUM_URI + albumId)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    public Response getAlbums() {
        return given()
                .get(ALBUM_URI)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    public Response addAlbum(int userId, String title, String body) {
        var album = new Album(userId, title);
        return given()
                .body(album)
                .post(ALBUM_URI)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    public Response updateAlbum(int id, int userId, String title, String body) {
        var album = new Album(id, userId, title);
        return given()
                .body(album)
                .put(ALBUM_URI + id)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    public Response deleteAlbum(int id) {
        return given()
                .delete(ALBUM_URI + id)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }
}
