package test_default_unimplemented_server_stubs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openapi.example.api.UserApi;
import org.openapi.example.invoker.ApiClient;
import org.openapi.example.model.User;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Arrays;

import static helper.ApiClientFactories.setUpUserApi;
import static org.junit.jupiter.api.Assertions.*;
import static helper.TestingHelper.approveException;

class UserApiTest {

    UserApi apiInstance;

    @BeforeEach
    void setUp() {
        apiInstance = setUpUserApi();
    }

    @Test
    void createUser() {
        var user = new User();
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.createUser(user).block();
        });

        approveException(exception);
    }

    @Test
    void createUsersWithArrayInput() {
        var user = new User();
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.createUsersWithArrayInput(Arrays.asList(user)).block();
                });

        approveException(exception);
    }

    @Test
    void createUsersWithListInput() {
        var user = new User();
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.createUsersWithListInput(Arrays.asList(user)).block();
                });

        approveException(exception);
    }

    @Test
    void deleteUser() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.deleteUser("my name").block();
                });

        approveException(exception);
    }

    @Test
    void getUserByName() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.getUserByName("my name").block();
                });

        approveException(exception);
    }

    @Test
    void loginUser() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.loginUser("my name", "my password").block();
                });

        approveException(exception);
    }

    @Test
    void logoutUser() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.logoutUser().block();
                });

        approveException(exception);
    }
}