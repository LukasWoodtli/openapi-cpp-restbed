package test_error_handling_server_stubs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
    void addPetThatThrowsApiException() {
        var pet = new Pet();
        pet.name("ThrowsApiException");
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
        pet.name("ThrowsStdExceptionDerivedException");
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
        pet.name("ThrowsInt");
        pet.status(Pet.StatusEnum.AVAILABLE);
        assertThrows(
                UnknownHttpStatusCodeException.class, () -> {
                    apiInstance.addPet(pet).block();
                });
    }

    @Test
    void addPetThatReturnsStatus200() {
        var pet = new Pet();
        pet.name("ReturnsStatus200");
        pet.status(Pet.StatusEnum.AVAILABLE);
        var response = apiInstance.addPet(pet).block();
        approveResponseAsJson(response);
    }

    @Test
    void addPetThatReturnsStatus405() {
        var pet = new Pet();
        pet.name("ReturnsStatus405");
        pet.status(Pet.StatusEnum.AVAILABLE);

        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.addPet(pet).block();
                });

        approveException(exception);
    }

    @Test
    void deletePetThrowsApiException() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.deletePet(1342L, "ThrowsApiException").block();
                });
        approveException(exception);
    }

    @Test
    void deletePetThrowsStdExceptionDerivedException() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.deletePet(1342L, "ThrowsStdExceptionDerivedException").block();
                });
        approveException(exception);
    }

    @Test
    @Disabled
    void deletePetThrowsInt() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.deletePet(1342L, "ThrowsInt").block();
                });
        approveException(exception);
    }

    @Test
    void deletePetReturnsStatus200() {
        apiInstance.deletePet(1342L, "ReturnsStatus200").block();
    }



    @Test
    void getPetById() {
    }

    @Test
    void updatePet() {
    }
}
