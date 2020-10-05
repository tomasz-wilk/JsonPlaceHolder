package com.epam.wilk.endpoints;

import com.epam.wilk.configuration.TestProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BaseEndpoint {
    @NonNull
    private TestProperties testProperties;

    protected RequestSpecification given() {
        return RestAssured.given().baseUri(testProperties.getBaseUrl()).port(-1).log().all().contentType(ContentType.JSON);
    }
}
