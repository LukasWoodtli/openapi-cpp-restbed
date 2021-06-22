package test_simple_server_stubs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openapi.example.api.PetApi;
import org.openapi.example.model.Category;
import org.openapi.example.model.Pet;
import org.openapi.example.model.Tag;
import java.util.List;

import static helper.ApiClientFactories.setUpPetApi;
import static helper.TestingHelper.approveResponseAsJson;

class PetApiTest {

    PetApi apiInstance;

    @BeforeEach
    void setUp() {
        apiInstance = setUpPetApi(1235);
    }

    @Test
    void addPet() {
        var pet = createTestPet();
        var responsePet = apiInstance.addPet(pet).block();

        approveResponseAsJson(responsePet);
    }

    @Test
    void deletePet() {
        apiInstance.deletePet(1L, "myApiKey").block();
    }

    @Test
    void getPetById() {
        var responsePet = apiInstance.getPetById(99L).block();
        approveResponseAsJson(responsePet);
    }

    @Test
    void updatePet() {
        var pet = createTestPet();
        var responsePet = apiInstance.updatePet(pet).block();

        approveResponseAsJson(responsePet);
    }

    private Pet createTestPet() {
        var pet = new Pet();

        pet.setId(12L);
        pet.setName("MyPet");
        pet.setStatus(Pet.StatusEnum.SOLD);

        var tag = new Tag();
        tag.name("MyTag");
        pet.addTagsItem(tag);

        var category = new Category();
        category.setId(1L);
        category.setName("MyCategory");
        pet.setCategory(category);

        pet.addPhotoUrlsItem("myUrl");

        return pet;
    }
}