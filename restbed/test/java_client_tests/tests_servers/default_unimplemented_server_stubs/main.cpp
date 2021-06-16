#include "api/PetApi.h"
#include "api/StoreApi.h"
#include "api/UserApi.h"

using namespace org::openapitools::server::api;

int main() {
  const auto service = std::make_shared<restbed::Service>();
  const auto settings = std::make_shared<restbed::Settings>();
  settings->set_port(1234);

  auto petApi = PetApi(service);
  petApi.publishDefaultResources();

  auto storeApi = StoreApi(service);
  storeApi.publishDefaultResources();

  auto userApi = UserApi(service);
  userApi.publishDefaultResources();

  service->start(settings);

}