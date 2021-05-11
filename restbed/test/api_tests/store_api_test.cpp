#define BOOST_TEST_INCLUDED
#include <boost/test/data/test_case.hpp>
#include <boost/test/unit_test.hpp>

#include <chrono>
#include <iostream>
#include <thread>
#include <functional>

#include "ApprovalTests.hpp"

#include "api/StoreApi.h"

extern "C" {
#include "apiClient.h"
#include "StoreAPI.h"
}

using namespace ApprovalTests;
using namespace org::openapitools::server::model;
using namespace org::openapitools::server::api;

class MyStoreApiStoreInventoryResource : public StoreApiStoreInventoryResource {
public:
  virtual std::pair<int, std::string> handler_GET() override {
      return std::make_pair<int, std::string>(200, "Hello inventory");
  }

};

BOOST_AUTO_TEST_SUITE(StoreApiTest)

BOOST_AUTO_TEST_CASE(startService)
{

  std::thread thread([]{
    auto storeApi = StoreApi(1234);
    std::shared_ptr<StoreApiStoreInventoryResource> res = std::make_shared<MyStoreApiStoreInventoryResource>();
    storeApi.setStoreApiStoreInventoryResource(res);
    storeApi.startService();
  });
  thread.detach();


  auto* client = apiClient_create();
  auto* result = StoreAPI_getInventory(client);
  listEntry_t* element;
  list_ForEach(element, result) {
    const auto kvp = (keyValuePair_t*)element->data;
    const auto key = kvp->key;
    std::cerr << key;
  }

  apiClient_free(client);


  std::this_thread::sleep_for(std::chrono::minutes (1));
  std::cerr << "service started";
}

BOOST_AUTO_TEST_SUITE_END()