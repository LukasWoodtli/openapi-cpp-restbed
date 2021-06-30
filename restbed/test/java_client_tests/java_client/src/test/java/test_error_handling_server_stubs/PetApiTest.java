package test_error_handling_server_stubs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openapi.example.api.PetApi;
import org.openapi.example.model.Pet;
import org.springframework.web.reactive.function.client.UnknownHttpStatusCodeException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import static helper.ApiClientFactories.setUpPetApi;
import static helper.TestingHelper.approveException;
import static helper.TestingHelper.approveResponseAsJson;
import static org.junit.jupiter.api.Assertions.*;

class PetApiTest {

    PetApi apiInstance;

    @BeforeEach
    void setUp() {
        apiInstance = setUpPetApi(1236);
    }

    @Test
    void addPetInvalidEnumValue() {
        var pet = new Pet();
        pet.name("PetWithInvalidStatus");
        pet.status(null); // not allowed
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.addPet(pet).block();
                });
        approveException(exception);
    }

    @Test
    void addPetThatThrowsPetApiException() {
        var pet = new Pet();
        pet.name("PetThatThrowsPetApiException");
        pet.status(Pet.StatusEnum.SOLD);
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.addPet(pet).block();
                });
        approveException(exception);
    }

    @Test
    void addPetThatThrowsStdExceptionDerivedException() {
        var pet = new Pet();
        pet.name("PetThatThrowsStdExceptionDerivedException");
        pet.status(Pet.StatusEnum.AVAILABLE);
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.addPet(pet).block();
                });
        approveException(exception);
    }

    @Test
    void addPetThatThrowsInt() {
        var pet = new Pet();
        pet.name("PetThatThrowsInt");
        pet.status(Pet.StatusEnum.AVAILABLE);
        assertThrows(
                UnknownHttpStatusCodeException.class, () -> {
                    apiInstance.addPet(pet).block();
                });
    }

    @Test
    void addPetThatReturnsStatus200() {
        var pet = new Pet();
        pet.name("addPetThatReturnsStatus200");
        pet.status(Pet.StatusEnum.AVAILABLE);
        var response = apiInstance.addPet(pet).block();
        approveResponseAsJson(response);
    }

    @Test
    void addPetThatReturnsStatus405() {
        var pet = new Pet();
        pet.name("addPetThatReturnsStatus405");
        pet.status(Pet.StatusEnum.AVAILABLE);

        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.addPet(pet).block();
                });

        approveException(exception);
    }

    @Test
    void deletePet() {
    }

    @Test
    void getPetById() {
    }

    @Test
    void updatePet() {
    }
}