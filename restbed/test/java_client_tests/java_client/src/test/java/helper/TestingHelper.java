package helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.approvaltests.Approvals;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class TestingHelper {
    public static void approveException(WebClientResponseException exception) {
        var message = "Status code: " + exception.getStatusCode() +
                "\nReason: " + exception.getResponseBodyAsString() +
                "\nResponse headers: " + exception.getHeaders();
        Approvals.verify(message);
    }

    public static void approveException(WebClientRequestException exception) {
        var message = "URI: " + exception.getUri() +
                "\nMethod: " + exception.getMethod () +
                "\nHeaders: " + exception.getHeaders() +
                "\nMessage: " + exception.getMessage();
        Approvals.verify(message);
    }

    public static void approveResponseAsJson(Object reponseObject) {
        ObjectMapper objectMapper = new ObjectMapper();

        String json = "";

        try {
            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(reponseObject);
        } catch (JsonProcessingException e) {
            json = e.toString();
        }
        Approvals.verify(json);
    }
}
