package helper;

import org.openapi.example.api.PetApi;
import org.openapi.example.api.StoreApi;
import org.openapi.example.api.UserApi;
import org.openapi.example.invoker.ApiClient;

public class ApiClientFactories {
    public static PetApi setUpPetApi() {
        return new PetApi(setUpDefaultApiClient());
    }

    public static StoreApi setUpStoreApi() {
        return new StoreApi(setUpDefaultApiClient());
    }
    public static UserApi setUpUserApi() {
        return new UserApi(setUpDefaultApiClient());
    }

    private static ApiClient setUpDefaultApiClient() {
        ApiClient defaultClient = new ApiClient();
        defaultClient.setBasePath("http://localhost:1234/v2");
        return defaultClient;
    }
}
