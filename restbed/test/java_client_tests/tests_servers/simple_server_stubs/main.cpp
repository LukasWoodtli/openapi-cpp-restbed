#include "api/PetApi.h"
#include "api/StoreApi.h"
#include "api/UserApi.h"

using namespace org::openapitools::server::api;

std::shared_ptr<Pet> createPetForTesting_1() {
  auto pet = std::make_shared<Pet>();
  pet->setName("HelloPet");
  pet->setId(23);
  pet->setStatus("available");
  return pet;
}

std::shared_ptr<Pet> createPetForTesting_2() {
  auto pet = std::make_shared<Pet>();
  pet->setName("HelloPet2");
  pet->setId(44);
  pet->setStatus("sold");
  return pet;
}

class MyPetApiPetResource : public PetApiPetResource {
public:
  std::pair<int, std::shared_ptr<Pet>>
  handler_POST(const std::shared_ptr<Pet> &Pet) override {
    return std::make_pair(200, Pet);
  }

  std::pair<int, std::shared_ptr<Pet>>
  handler_PUT(const std::shared_ptr<Pet> &Pet) override {
    return std::make_pair(200, Pet);
  }
};

class MyPetApiPetPetIdResource : public PetApiPetPetIdResource {
public:
  int handler_DELETE(const int64_t &petId,
                     const std::string &api_key) override {
    return 200;
  }

  std::pair<int, std::shared_ptr<Pet>>
  handler_GET(const int64_t &petId) override {
    std::shared_ptr<Pet> pet = createPetForTesting_1();

    return std::make_pair(200, pet);
  }
};


int main() {
  const auto service = std::make_shared<restbed::Service>();

  auto petApi = PetApi(service);
  petApi.setPetApiPetPetIdResource(std::make_shared<MyPetApiPetPetIdResource>());
  petApi.setPetApiPetResource(std::make_shared<MyPetApiPetResource>());

  /*
  auto storeApi = StoreApi(service);
  storeApi.publishDefaultResources();

  auto userApi = UserApi(service);
  userApi.publishDefaultResources();
*/
  const auto settings = std::make_shared<restbed::Settings>();
  settings->set_port(1235);

  service->start(settings);

}