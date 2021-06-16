package helper;

import org.approvaltests.Approvals;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class TestingHelper {
    public static void approveException(WebClientResponseException exception) {
        var message = "Status code: " + exception.getStatusCode() +
                "\nReason: " + exception.getResponseBodyAsString() +
                "\nResponse headers: " + exception.getHeaders();
        Approvals.verify(message);
    }
}
