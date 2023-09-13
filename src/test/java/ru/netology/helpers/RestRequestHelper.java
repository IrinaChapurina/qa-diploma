package ru.netology.helpers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestRequestHelper {
    private static final RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(8080)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public static void sendRequest(DataHelper.FormData formData, String path) {
        given()
                .spec(requestSpec)
                .body(formData)
                .when()
                .post(path)
                .then()
                .log().all()
                .statusCode(200);
    }
    public static void sendBadRequest(DataHelper.FormData formData, String path) {
        given()
                .spec(requestSpec)
                .body(formData)
                .when()
                .post(path)
                .then()
                .log().all()
                .statusCode(500);
    }
}