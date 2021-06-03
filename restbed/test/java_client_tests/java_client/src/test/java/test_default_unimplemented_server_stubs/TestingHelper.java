package test_default_unimplemented_server_stubs;

import org.approvaltests.Approvals;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class TestingHelper {
    static void approveException(WebClientResponseException exception) {
        var message = "Status code: " + exception.getStatusCode() +
                "\nReason: " + exception.getResponseBodyAsString() +
                "\nResponse headers: " + exception.getHeaders();
        Approvals.verify(message);
    }
}
