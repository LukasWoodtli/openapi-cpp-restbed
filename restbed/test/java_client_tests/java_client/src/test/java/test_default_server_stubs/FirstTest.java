package test_default_server_stubs;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.approvaltests.Approvals;
import org.openapi.example.api.PetApi;
import org.openapi.example.api.StoreApi;
import org.openapi.example.invoker.ApiClient;
import org.openapi.example.model.Pet;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;


public class FirstTest {

    @Test
    void example() throws JsonProcessingException {
        ApiClient defaultClient = new ApiClient();
        defaultClient.setBasePath("http://localhost:1234/v2");

        PetApi apiInstance = new PetApi(defaultClient);
        Pet pet = new Pet(); // Pet | Pet object that needs to be added to the store
        Mono<Pet> result = apiInstance.addPet(pet);
        System.out.println(result);
       /* } catch (WebClientResponseException e) {
            System.err.println("Exception when calling PetApi#addPet");
            System.err.println("Status code: " + e.getStatusCode());
            System.err.println("Reason: " + e.getResponseBodyAsString());
            System.err.println("Response headers: " + e.getHeaders());
            e.printStackTrace();
        }*/

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(result);
        Approvals.verify(jsonString);
    }

}


