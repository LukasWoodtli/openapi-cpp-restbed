package test_error_handling_server_stubs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openapi.example.api.StoreApi;
import org.openapi.example.model.Order;
import org.springframework.core.codec.DecodingException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import static helper.ApiClientFactories.setUpStoreApi;
import static helper.TestingHelper.*;
import static org.junit.jupiter.api.Assertions.*;

class StoreApiTest {

    StoreApi apiInstance;

    @BeforeEach
    void setUp() {
        apiInstance = setUpStoreApi(1236);
    }

    @Test
    void deleteOrderThrowsApiException() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.deleteOrder("ThrowsApiException").block();
                });
        approveException(exception);
    }

    @Test
    void deleteOrderThrowsStdExceptionDerivedException() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.deleteOrder("ThrowsStdExceptionDerivedException").block();
                });
        approveException(exception);
    }

    @Test
    void deleteOrderThrowsInt() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.deleteOrder("ThrowsInt").block();
                });
        approveException(exception);
    }

    @Test
    void deleteOrderReturnsStatus200() {
        apiInstance.deleteOrder("ReturnsStatus200").block();
    }

    @Test
    void deleteOrderReturnsStatus400() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.deleteOrder("ReturnsStatus400").block();
                });

        approveException(exception);
    }

    @Test
    void deleteOrderReturnsStatus404() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.deleteOrder("ReturnsStatus404").block();
                });

        approveException(exception);
    }
    @Test
    void deleteOrderReturnsStatus405() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.deleteOrder("ReturnsStatus405").block();
                });

        approveException(exception);
    }

    @Test
    void getInventory() {
        var ret = apiInstance.getInventory().block();
        assertNull(ret);
    }

    @Test
    void getOrderByIdThrowsApiException() {
        var id = errorRaisingStringToInt("ThrowsApiException");
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.getOrderById(id).block();
                });
        approveException(exception);
    }

    @Test
    void getOrderByIdThrowsStdExceptionDerivedException() {
        var id = errorRaisingStringToInt("ThrowsStdExceptionDerivedException");
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.getOrderById(id).block();
                });
        approveException(exception);
    }

    @Test
    void getOrderByIdThrowsInt() {
        var id = errorRaisingStringToInt("ThrowsInt");
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.getOrderById(id).block();
                });
        approveException(exception);
    }

    @Test
    void getOrderByIdReturnsStatus200WithInvalidEnumValue() {
        var id = errorRaisingStringToInt("ReturnsStatus200");
        var exception = assertThrows(DecodingException.class, () -> {
                apiInstance.getOrderById(id).block();
        });
    }

    @Test
    void getOrderByIdReturnsStatus300() {
        var id = errorRaisingStringToInt("ReturnsStatus300");
        var resp = apiInstance.getOrderById(id).block();
        assertNull(resp);
    }

    @Test
    void getOrderByIdReturnsStatus400() {
        var id = errorRaisingStringToInt("ReturnsStatus400");
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.getOrderById(id).block();
                });
        approveException(exception);
    }

    @Test
    void getOrderByIdReturnsStatus404() {
        var id = errorRaisingStringToInt("ReturnsStatus404");
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.getOrderById(id).block();
                });
        approveException(exception);
    }

    @Test
    void placeOrderThrowsApiException() {
        var id = errorRaisingStringToInt("ThrowsApiException");

        var order = new Order();
        order.setId(id);
        order.setStatus(Order.StatusEnum.PLACED);

        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.placeOrder(order).block();
                });
        approveException(exception);

    }

    @Test
    void placeOrderThrowsStdExceptionDerivedException() {
        var id = errorRaisingStringToInt("ThrowsStdExceptionDerivedException");

        var order = new Order();
        order.setId(id);
        order.setStatus(Order.StatusEnum.PLACED);

        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.placeOrder(order).block();
                });
        approveException(exception);

    }

    @Test
    void placeOrderThrowsInt() {
        var id = errorRaisingStringToInt("ThrowsInt");

        var order = new Order();
        order.setId(id);
        order.setStatus(Order.StatusEnum.PLACED);

        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.placeOrder(order).block();
                });
        approveException(exception);

    }

    @Test
    void placeOrderReturnsStatus300() {
        var id = errorRaisingStringToInt("ReturnsStatus300");

        var order = new Order();
        order.setId(id);
        order.setStatus(Order.StatusEnum.PLACED);

        var resp = apiInstance.placeOrder(order).block();

        assertNull(resp);
    }

    @Test
    void placeOrderReturnsStatus400() {
        var id = errorRaisingStringToInt("ReturnsStatus400");

        var order = new Order();
        order.setId(id);
        order.setStatus(Order.StatusEnum.PLACED);

        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.placeOrder(order).block();
                });
        approveException(exception);
    }
}