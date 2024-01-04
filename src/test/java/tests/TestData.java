package tests;

import models.LoginRequestModel;

public class TestData {
    private static String login = "nikita123",
            password = "NIKita123*";

    public static LoginRequestModel credentials = new LoginRequestModel(login, password);
}