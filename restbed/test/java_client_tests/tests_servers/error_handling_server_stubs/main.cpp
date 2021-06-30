#include "api/PetApi.h"
#include "api/StoreApi.h"
#include "api/UserApi.h"

#include <stdexcept>

using namespace org::openapitools::server::api;

class MyPetApiPetResource : public PetApiPetResource {
public:
  std::pair<int, std::shared_ptr<Pet>>
  handler_POST(const std::shared_ptr<Pet> &pet) override {

    const std::string &name = pet->getName();

    if ("PetWithInvalidStatus" == name) {
      return std::make_pair(500, pet);
    }
    else if ("PetThatThrowsPetApiException" == name) {
      throw PetApiException(500, "PetWithPetApiException raised");
    }
    else if ("PetThatThrowsStdExceptionDerivedException" == name) {
      throw std::logic_error("std::logic_error raised");
    }
    else if ("PetThatThrowsInt" == name) {
      throw int(1);
    }
    else if ("addPetThatReturnsStatus200" == name) {
      return {200, pet};
    }
    else if ("addPetThatReturnsStatus405" == name) {
      return {405, pet};
    }

    return std::make_pair(500, pet);
  }

  /*
  std::pair<int, std::shared_ptr<Pet>>
  handler_PUT(const std::shared_ptr<Pet> &Pet) override {
    return std::make_pair(200, Pet);
  }*/
};



int main() {
  const auto service = std::make_shared<restbed::Service>();

  auto petApi = PetApi(service);
  petApi.setPetApiPetResource(std::make_shared<MyPetApiPetResource>());
  //petApi.setPetApiPetPetIdResource(std::make_shared<MyPetApiPetPetIdResource>());

  const auto settings = std::make_shared<restbed::Settings>();
  settings->set_port(1236);

  service->start(settings);

}
