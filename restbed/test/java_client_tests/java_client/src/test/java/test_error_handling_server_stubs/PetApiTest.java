package test_error_handling_server_stubs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openapi.example.api.PetApi;
import org.openapi.example.model.Pet;
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
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.addPet(pet).block();
                });

        approveException(exception);
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
    void deletePetReturnsStatus400() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.deletePet(1342L, "ReturnsStatus400").block();
                });
        approveException(exception);
    }

    @Test
    void deletePetReturnsStatus300() {
        apiInstance.deletePet(1342L, "ReturnsStatus300").block();
    }

    @Test
    void getPetByIdThrowsApiException() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.getPetById(9100L).block();
                });
        approveException(exception);
    }

    @Test
    void getPetByIdThrowsStdExceptionDerivedException() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.getPetById(9200L).block();
                });
        approveException(exception);
    }

    @Test
    void getPetByIdThrowsInt() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.getPetById(9300L).block();
                });
        approveException(exception);
    }

    @Test
    void getPetByIdReturnsStatus200() {
        var pet = apiInstance.getPetById(200L).block();
        approveResponseAsJson(pet);
    }

    @Test
    void getPetByIdReturnsStatus300() {
        var pet = apiInstance.getPetById(300L).block();
        assertNull(pet);
    }

    @Test
    void getPetByIdReturnsStatus400() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.getPetById(400L).block();
                });
        approveException(exception);
    }

    @Test
    void getPetByIdReturnsStatus404() {
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.getPetById(404L).block();
                });
        approveException(exception);
    }

    @Test
    void updatePetThrowsApiException() {
        var pet = new Pet();
        pet.name("ThrowsApiException");
        pet.status(Pet.StatusEnum.SOLD);
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.updatePet(pet).block();
                });
        approveException(exception);
    }

    @Test
    void updatePetThrowsStdExceptionDerivedException() {
        var pet = new Pet();
        pet.name("ThrowsStdExceptionDerivedException");
        pet.status(Pet.StatusEnum.SOLD);
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.updatePet(pet).block();
                });
        approveException(exception);
    }

    @Test
    void updatePetThrowsInt() {
        var pet = new Pet();
        pet.name("ThrowsInt");
        pet.status(Pet.StatusEnum.SOLD);
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.updatePet(pet).block();
                });
        approveException(exception);
    }


    @Test
    void updatePetReturnsStatus400() {
        var pet = new Pet();
        pet.name("ReturnsStatus400");
        pet.status(Pet.StatusEnum.SOLD);
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.updatePet(pet).block();
                });
        approveException(exception);
    }

    @Test
    void updatePetReturnsStatus300() {
        var pet = new Pet();
        pet.name("ReturnsStatus300");
        pet.status(Pet.StatusEnum.SOLD);

        var resp = apiInstance.updatePet(pet).block();
        assertNull(resp);
    }

    @Test
    void updatePetReturnsStatus404() {
        var pet = new Pet();
        pet.name("ReturnsStatus404");
        pet.status(Pet.StatusEnum.SOLD);
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.updatePet(pet).block();
                });
        approveException(exception);
    }

    @Test
    void updatePetReturnsStatus405() {
        var pet = new Pet();
        pet.name("ReturnsStatus405");
        pet.status(Pet.StatusEnum.SOLD);
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.updatePet(pet).block();
                });
        approveException(exception);
    }
    @Test
    void updatePetReturnsStatus500() {
        var pet = new Pet();
        pet.name("ReturnsStatus500");
        pet.status(Pet.StatusEnum.SOLD);
        var exception = assertThrows(
                WebClientResponseException.class, () -> {
                    apiInstance.updatePet(pet).block();
                });
        approveException(exception);
    }
}
