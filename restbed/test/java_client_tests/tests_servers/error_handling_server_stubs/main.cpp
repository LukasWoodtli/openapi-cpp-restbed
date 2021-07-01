#include "api/PetApi.h"
#include "api/StoreApi.h"
#include "api/UserApi.h"

#include <stdexcept>

#include<signal.h>
void sig_handler(int signum){
  printf("\nSIGINT received!\n");
  exit(0);
}

using namespace org::openapitools::server::api;

namespace {
const auto RETURN_STATUS = std::string("ReturnsStatus");

bool isReturnStatusString(const std::string &errorType) {
  return errorType.rfind(RETURN_STATUS, 0) == 0;
}

int extractReturnStatus(const std::string &errorType) {
  assert(isReturnStatusString(errorType));

  auto returnValString = errorType;
  returnValString.erase(0, RETURN_STATUS.length());

  return std::stoi(returnValString);
}


template <class RETURN_T, class API_EXCEPTION_T>
std::pair<int, std::shared_ptr<Pet>>
raiseErrorForTesting(const std::shared_ptr<RETURN_T> &modelObj,
                     const std::string &errorType) {
  if ("ThrowsApiException" == errorType) {
    throw API_EXCEPTION_T(500, "ApiException raised");
  } else if ("ThrowsStdExceptionDerivedException" == errorType) {
    throw std::logic_error("std::logic_error raised");
  } else if ("ThrowsInt" == errorType) {
    throw int(1);
  }  else if (isReturnStatusString(errorType)) {
    auto retStatus = extractReturnStatus(errorType);
    return {retStatus, modelObj};
  }

  return std::make_pair(500, modelObj);
}

} // namespace

class MyPetApiPetResource : public PetApiPetResource {
public:
  std::pair<int, std::shared_ptr<Pet>>
  handler_POST(const std::shared_ptr<Pet> &pet) override {

    const std::string &name = pet->getName();

    return raiseErrorForTesting<Pet, PetApiException>(pet, name);
  }

  /*
  std::pair<int, std::shared_ptr<Pet>>
  handler_PUT(const std::shared_ptr<Pet> &Pet) override {
    return std::make_pair(200, Pet);
  }*/
};

class MyPetApiPetPetIdResource : public PetApiPetPetIdResource {
public:
  int handler_DELETE(const int64_t &petId,
                     const std::string &api_key) override {
    auto [status, pet] = raiseErrorForTesting<Pet, PetApiException>(std::make_shared<Pet>(), api_key);
    return status;
  }

  /*std::pair<int, std::shared_ptr<Pet>>
  handler_GET(const int64_t &petId) override {
    return PetApiPetPetIdResource::handler_GET(petId);
  }*/
};

int main() {
  signal(SIGINT,sig_handler);

  const auto service = std::make_shared<restbed::Service>();

  auto petApi = PetApi(service);
  petApi.setPetApiPetResource(std::make_shared<MyPetApiPetResource>());
  petApi.setPetApiPetPetIdResource(std::make_shared<MyPetApiPetPetIdResource>());

  const auto settings = std::make_shared<restbed::Settings>();
  settings->set_port(1236);

  service->start(settings);

}
