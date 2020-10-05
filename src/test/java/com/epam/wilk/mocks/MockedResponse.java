package com.epam.wilk.mocks;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.config.XmlPathConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MockedResponse implements Response {

    int statusCode;
    ContentType contentType;

    public MockedResponse(int statusCode, ContentType contentType){
        this.statusCode = statusCode;
        this.contentType = contentType;
    }

    @Override
    public String print() {
        return null;
    }

    @Override
    public String prettyPrint() {
        return null;
    }

    @Override
    public Response peek() {
        return null;
    }

    @Override
    public Response prettyPeek() {
        return null;
    }

    @Override
    public <T> T as(Class<T> aClass) {
        return null;
    }

    @Override
    public <T> T as(Class<T> aClass, ObjectMapperType objectMapperType) {
        return null;
    }

    @Override
    public <T> T as(Class<T> aClass, ObjectMapper objectMapper) {
        return null;
    }

    @Override
    public JsonPath jsonPath() {
        return null;
    }

    @Override
    public JsonPath jsonPath(JsonPathConfig jsonPathConfig) {
        return null;
    }

    @Override
    public XmlPath xmlPath() {
        return null;
    }

    @Override
    public XmlPath xmlPath(XmlPathConfig xmlPathConfig) {
        return null;
    }

    @Override
    public XmlPath xmlPath(XmlPath.CompatibilityMode compatibilityMode) {
        return null;
    }

    @Override
    public XmlPath htmlPath() {
        return null;
    }

    @Override
    public <T> T path(String s, String... strings) {
        return null;
    }

    @Override
    public String asString() {
        return null;
    }

    @Override
    public byte[] asByteArray() {
        return new byte[0];
    }

    @Override
    public InputStream asInputStream() {
        return null;
    }

    @Override
    public Response andReturn() {
        return null;
    }

    @Override
    public Response thenReturn() {
        return null;
    }

    @Override
    public ResponseBody body() {
        return null;
    }

    @Override
    public ResponseBody getBody() {
        return null;
    }

    @Override
    public Headers headers() {
        return null;
    }

    @Override
    public Headers getHeaders() {
        return null;
    }

    @Override
    public String header(String s) {
        return null;
    }

    @Override
    public String getHeader(String s) {
        return null;
    }

    @Override
    public Map<String, String> cookies() {
        return null;
    }

    @Override
    public Cookies detailedCookies() {
        return null;
    }

    @Override
    public Map<String, String> getCookies() {
        return null;
    }

    @Override
    public Cookies getDetailedCookies() {
        return null;
    }

    @Override
    public String cookie(String s) {
        return null;
    }

    @Override
    public String getCookie(String s) {
        return null;
    }

    @Override
    public Cookie detailedCookie(String s) {
        return null;
    }

    @Override
    public Cookie getDetailedCookie(String s) {
        return null;
    }

    @Override
    public String contentType() {
        return this.contentType.toString();
    }

    @Override
    public String getContentType() {
        return this.contentType.toString();
    }

    @Override
    public String statusLine() {
        return null;
    }

    @Override
    public String getStatusLine() {
        return null;
    }

    @Override
    public String sessionId() {
        return null;
    }

    @Override
    public String getSessionId() {
        return null;
    }

    @Override
    public int statusCode() {
        return this.statusCode;
    }

    @Override
    public int getStatusCode() {
        return this.statusCode;
    }

    @Override
    public long time() {
        return 0;
    }

    @Override
    public long timeIn(TimeUnit timeUnit) {
        return 0;
    }

    @Override
    public long getTime() {
        return 0;
    }

    @Override
    public long getTimeIn(TimeUnit timeUnit) {
        return 0;
    }

    @Override
    public ValidatableResponse then() {
        return null;
    }
}
