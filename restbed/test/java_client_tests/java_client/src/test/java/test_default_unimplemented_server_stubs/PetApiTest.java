package test_default_unimplemented_server_stubs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openapi.example.api.PetApi;
import org.openapi.example.model.Pet;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Arrays;

import static helper.ApiClientFactories.setUpPetApi;
import static helper.TestingHelper.approveException;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PetApiTest {

    PetApi apiInstance;

    @BeforeEach
    void setUp() {
        apiInstance = setUpPetApi();
    }

    @Test
    void addPet() {
        Pet pet = new Pet();
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.addPet(pet).block();
                });

        approveException(exception);
    }

    @Test
    void deletePet() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.deletePet(99L, "myApiKey").block();
                });

        approveException(exception);
    }

    @Test
    void findPetsByStatus() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.findPetsByStatus(Arrays.asList("hello")).blockFirst();
                });

        approveException(exception);
    }

    @Test
    void findPetsByTags() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.findPetsByTags(Arrays.asList("hello Tag")).blockFirst();
                });

        approveException(exception);
    }

    @Test
    void getPetById() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.getPetById(9L).block();
                });

        approveException(exception);
    }

    @Test
    void updatePet() {
        var pet = new Pet();
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.updatePet(pet).block();
                });

        approveException(exception);
    }

}