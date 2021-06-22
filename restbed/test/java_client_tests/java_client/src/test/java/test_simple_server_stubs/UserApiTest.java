package test_simple_server_stubs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openapi.example.api.UserApi;
import org.openapi.example.model.User;

import java.util.ArrayList;
import java.util.List;

import static helper.ApiClientFactories.setUpUserApi;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserApiTest {

    UserApi apiInstance;

    @BeforeEach
    void setUp() {
        apiInstance = setUpUserApi(1235);
    }

    @Test
    void createUser() {
        var user = new User();
        apiInstance.createUser(user).block();
    }

    @Test
    void createUsersWithArrayInput() {
        List<User> users = createUsersForTests();
        apiInstance.createUsersWithArrayInput(users).block();
    }

    @Test
    void createUsersWithListInput() {
        List<User> users = createUsersForTests();
        apiInstance.createUsersWithListInput(users).block();
    }

    @Test
    void loginUser() {
        final var username = "user1";
        var response = apiInstance.loginUser(username, "pa55w0rd").block();
        assertEquals(response, username);
    }

    @Test
    void logoutUser() {
        apiInstance.logoutUser().block();
    }


    private static List<User> createUsersForTests() {
        List<User> users = new ArrayList<>();

        var user1 = new User();
        user1.setUsername("User1");
        user1.setId(7L);
        users.add(user1);

        var user2 = new User();
        user2.setUsername("User2");
        user2.setId(8L);
        users.add(user2);
        return users;
    }
}