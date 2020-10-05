package com.epam.wilk.tests;

import com.epam.wilk.endpoints.PostEndpoint;
import com.epam.wilk.mocks.MockedResponse;
import com.epam.wilk.steps.PostSteps;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockIT extends BaseIT {
    private static int TEST_POST_ID = 50;

    @Autowired
    private PostSteps postSteps;

    @Test
    public void verifyMockitoForFunMock() {
        var postEndpoint = mock(PostEndpoint.class);
        when(postEndpoint.getPost(TEST_POST_ID)).thenReturn(new MockedResponse(HttpStatus.SC_OK, ContentType.JSON));
        var response = postEndpoint.getPost(TEST_POST_ID);
        var softly = new SoftAssertions();
        softly.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
        softly.assertThat(response.getContentType()).isEqualTo(ContentType.JSON.toString());
        softly.assertThat(response.getBody()).isNull();
        softly.assertAll();
    }

    @Test
    public void verifyMockitoForFunEmptyMock() {
        var postEndpoint = mock(PostEndpoint.class);
        var response = postEndpoint.getPost(TEST_POST_ID);
        assertThat(response).isNull();
    }
}
