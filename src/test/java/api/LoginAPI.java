package api;

import models.LoginRequestModel;
import models.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static specs.LoginSpecs.loginRequestSpecBase;
import static specs.LoginSpecs.loginResponseSpec;

public class LoginAPI {
    public LoginResponseModel login(LoginRequestModel credentials) {
        return given(loginRequestSpecBase)
                .body(credentials)
                .contentType(JSON)
                .when()
                .post("/Account/v1/Login")
                .then()
                .spec(loginResponseSpec)
                .statusCode(200)
                .extract().as(LoginResponseModel.class);
    }
}