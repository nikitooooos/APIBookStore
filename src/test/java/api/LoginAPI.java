package api;

import models.LoginRequestModel;
import models.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static specs.Specs.requestSpec;
import static specs.Specs.responseSpec;

public class LoginAPI {
    public LoginResponseModel login(LoginRequestModel credentials) {
        return given(requestSpec)
                .body(credentials)
                .contentType(JSON)
                .when()
                .post("/Account/v1/Login")
                .then()
                .spec(responseSpec)
                .statusCode(200)
                .extract().as(LoginResponseModel.class);
    }
}