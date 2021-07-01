package test_error_handling_server_stubs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openapi.example.api.UserApi;
import org.openapi.example.model.User;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.ArrayList;
import java.util.List;

import static helper.ApiClientFactories.setUpUserApi;
import static helper.TestingHelper.approveException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserApiTest {

    UserApi apiInstance;

    @BeforeEach
    void setUp() {
        apiInstance = setUpUserApi(1236);
    }

    @Test
    void createUserThrowsApiException() {
        var user = new User();
        user.setFirstName("ThrowsApiException");
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.createUser(user).block();
                });
        approveException(exception);
    }

    @Test
    void createUserThrowsStdExceptionDerivedException() {
        var user = new User();
        user.setFirstName("ThrowsStdExceptionDerivedException");
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.createUser(user).block();
                });
        approveException(exception);
    }

    @Test
    void createUserThrowsInt() {
        var user = new User();
        user.setFirstName("ThrowsInt");
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.createUser(user).block();
                });
        approveException(exception);
    }

    @Test
    void createUserReturnsStatus0() {
        var user = new User();
        user.setFirstName("ReturnsStatus0");

        apiInstance.createUser(user).block();
    }


    @Test
    void createUserReturnsStatus400() {
        var user = new User();
        user.setFirstName("ReturnsStatus400");
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.createUser(user).block();
                });
        approveException(exception);
    }

    @Test
    void createUserReturnsStatus500() {
        var user = new User();
        user.setFirstName("ReturnsStatus500");
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.createUser(user).block();
                });
        approveException(exception);
    }

    @Test
    void createUsersWithArrayInputThrowsApiException() {
        List<User> users = new ArrayList<>();
        var user = new User();
        user.setFirstName("ThrowsApiException");
        users.add(user);
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.createUsersWithArrayInput(users).block();
                });
        approveException(exception);
    }

    @Test
    void createUsersWithArrayInputThrowsStdExceptionDerivedException() {
        List<User> users = new ArrayList<>();
        var user = new User();
        user.setFirstName("ThrowsStdExceptionDerivedException");
        users.add(user);
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.createUsersWithArrayInput(users).block();
                });
        approveException(exception);
    }

    @Test
    void createUsersWithArrayInputThrowsInt() {
        List<User> users = new ArrayList<>();
        var user = new User();
        user.setFirstName("ThrowsInt");
        users.add(user);
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.createUsersWithArrayInput(users).block();
                });
        approveException(exception);
    }

    @Test
    void createUsersWithArrayInputReturnsStatus0() {
        List<User> users = new ArrayList<>();
        var user = new User();
        user.setFirstName("ReturnsStatus0");
        users.add(user);

        apiInstance.createUsersWithArrayInput(users).block();
    }

    @Test
    void createUsersWithArrayInputReturnsStatus400() {
        List<User> users = new ArrayList<>();
        var user = new User();
        user.setFirstName("ReturnsStatus400");
        users.add(user);

        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.createUsersWithArrayInput(users).block();
                });
        approveException(exception);
    }

    @Test
    void createUsersWithArrayInputReturnsStatus500() {
        List<User> users = new ArrayList<>();
        var user = new User();
        user.setFirstName("ReturnsStatus500");
        users.add(user);

        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.createUsersWithArrayInput(users).block();
                });
        approveException(exception);
    }

    @Test
    void createUsersWithListInputThrowsApiException() {
        List<User> users = new ArrayList<>();
        var user = new User();
        user.setFirstName("ThrowsApiException");
        users.add(user);
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.createUsersWithListInput(users).block();
                });
        approveException(exception);
    }

    @Test
    void createUsersWithListInputThrowsStdExceptionDerivedException() {
        List<User> users = new ArrayList<>();
        var user = new User();
        user.setFirstName("ThrowsStdExceptionDerivedException");
        users.add(user);
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.createUsersWithListInput(users).block();
                });
        approveException(exception);
    }

    @Test
    void createUsersWithListInputThrowsInt() {
        List<User> users = new ArrayList<>();
        var user = new User();
        user.setFirstName("ThrowsInt");
        users.add(user);
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.createUsersWithListInput(users).block();
                });
        approveException(exception);
    }

    @Test
    void createUsersWithListInputReturnsStatus0() {
        List<User> users = new ArrayList<>();
        var user = new User();
        user.setFirstName("ReturnsStatus0");
        users.add(user);

        apiInstance.createUsersWithListInput(users).block();
    }

    @Test
    void createUsersWithListInputReturnsStatus400() {
        List<User> users = new ArrayList<>();
        var user = new User();
        user.setFirstName("ReturnsStatus400");
        users.add(user);

        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.createUsersWithListInput(users).block();
                });
        approveException(exception);
    }

    @Test
    void createUsersWithListInputReturnsStatus500() {
        List<User> users = new ArrayList<>();
        var user = new User();
        user.setFirstName("ReturnsStatus500");
        users.add(user);

        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.createUsersWithListInput(users).block();
                });
        approveException(exception);
    }

    @Test
    void loginUserThrowsApiException() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.loginUser("ThrowsApiException", "mypassword").block();
                });
        approveException(exception);
    }

    @Test
    void loginUserThrowsStdExceptionDerivedException() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.loginUser("ThrowsStdExceptionDerivedException", "mypassword").block();
                });
        approveException(exception);
    }

    @Test
    void loginUserThrowsInt() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.loginUser("ThrowsInt", "mypassword").block();
                });
        approveException(exception);
    }

    @Test
    void loginUserReturnsStatus200() {
        var resp = apiInstance.loginUser("ReturnsStatus200", "mypassword").block();
        assertEquals("ReturnsStatus200", resp);
    }

    @Test
    void loginUserReturnsStatus400() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.loginUser("ReturnsStatus400", "mypassword").block();
                });
        approveException(exception);
    }

    @Test
    void loginUserReturnsStatus500() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.loginUser("ReturnsStatus500", "mypassword").block();
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