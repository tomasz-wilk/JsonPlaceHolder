package com.epam.wilk.tests;

import com.epam.wilk.endpoints.AlbumEndpoint;
import com.epam.wilk.models.Album;
import com.epam.wilk.steps.AlbumSteps;
import com.epam.wilk.utils.JsonConverter;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class AlbumIT extends BaseIT {

    private static int TEST_ALBUM_ID = 25;

    @Autowired
    private AlbumSteps albumSteps;

    @Autowired
    private AlbumEndpoint albumEndpoint;

    private static Stream<Arguments> testMetadata() {
        return Stream.of(
                Arguments.of("success scenario - existing album", TEST_ALBUM_ID, HttpStatus.SC_OK),
                Arguments.of("negative scenario - non existing album", 120, HttpStatus.SC_NOT_FOUND),
                Arguments.of("negative scenario - invalid id", -5, HttpStatus.SC_NOT_FOUND)
        );
    }

    @Test
    @DisplayName("Verify single album")
    @Description("Verify single album")
    public void verifyAlbum() {
        var response = albumEndpoint.getAlbum(TEST_ALBUM_ID);

        assertThat(response.getStatusCode())
                .as("wrong status code")
                .isEqualTo(HttpStatus.SC_OK);

        var album = JsonConverter.convertToJson(response, Album.class);

        albumSteps.verifyAlbum(album, TEST_ALBUM_ID, 3);
    }

    @ParameterizedTest
    @MethodSource("testMetadata")
    @DisplayName("Verify single album - parametrized")
    public void verifyAlbumParametrized(String description, int albumId, int expStatus) {
        var response = albumEndpoint.getAlbum(albumId);

        assertThat(response.getStatusCode())
                .as("wrong status code")
                .isEqualTo(expStatus);
    }
}
