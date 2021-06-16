#include "api/PetApi.h"
#include "api/StoreApi.h"
#include "api/UserApi.h"

using namespace org::openapitools::server::api;

int main() {
  const auto service = std::make_shared<restbed::Service>();
  const auto settings = std::make_shared<restbed::Settings>();
  settings->set_port(1234);
  settings->set_root("/v2");

  auto petApi = PetApi(service, settings);
  petApi.publishResources();

  auto storeApi = StoreApi(service, settings);
  storeApi.publishResources();

  auto userApi = UserApi(service, settings);
  userApi.publishResources();

  service->start(settings);

}