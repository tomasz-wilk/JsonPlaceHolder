package com.epam.wilk.steps;

import com.epam.wilk.models.Album;
import org.assertj.core.api.SoftAssertions;
import org.springframework.stereotype.Component;

@Component
public class AlbumSteps {
    public void verifyAlbum(Album actualAlbum, Integer id, Integer userId, String title) {
        var softly = new SoftAssertions();
        softly.assertThat(actualAlbum.getId())
                .isEqualTo(id);
        softly.assertThat(actualAlbum.getUserId())
                .isEqualTo(userId);
        softly.assertThat(actualAlbum.getTitle())
                .isEqualTo(title);
        softly.assertAll();
    }

    public void verifyAlbum(Album actualAlbum, Integer id, Integer userId) {
        var softly = new SoftAssertions();
        softly.assertThat(actualAlbum.getId())
                .isEqualTo(id);
        softly.assertThat(actualAlbum.getUserId())
                .isEqualTo(userId);
        softly.assertThat(actualAlbum.getTitle())
                .isNotNull();
        softly.assertAll();
    }
}
