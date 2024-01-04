package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import api.BookAPI;
import api.LoginAPI;
import models.AddBookListModel;
import models.LoginResponseModel;
import pages.ProfilePage;

import static io.qameta.allure.Allure.step;
import static tests.TestData.credentials;

public class DeleteOneBookTest extends TestBase {

    LoginAPI loginAPI = new LoginAPI();
    BookAPI bookApi = new BookAPI();
    ProfilePage profile = new ProfilePage();

    @Test
    @DisplayName("API тест на удаление товара из корзины")
    void deleteOneBookTest() {

        String isbn = "9781491904244";

        LoginResponseModel loginResponse = loginAPI.login(credentials);

        step("Авторизация по API", () ->
                bookApi.deleteAllBooks(loginResponse));

        step("Добавить книгу в профиль", () ->
                bookApi.addBook(loginResponse, new AddBookListModel()));

        step("Удалить книгу из профиля", () ->
                bookApi.deleteOneBook(loginResponse, isbn));

        step("Проверить, что книга в профиле отсутствует", () -> {
            profile.setCookie(loginResponse)
                    .openProfile()
                    .checkAvailabilityBook(isbn);
        });
    }
}