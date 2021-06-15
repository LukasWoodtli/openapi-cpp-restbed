#include "api/PetApi.h"

using namespace org::openapitools::server::api;

int main() {
  auto petApi = PetApi(1234);
  petApi.startService();
}