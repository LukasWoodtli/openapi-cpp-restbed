#include "api/PetApi.h"

using namespace org::openapitools::server::api;

int main() {
  const auto service = std::make_shared<restbed::Service>();
  const auto settings = std::make_shared<restbed::Settings>();
  settings->set_port(1234);
  auto petApi = PetApi(service, settings);
  petApi.startService();
}