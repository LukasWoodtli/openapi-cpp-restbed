#define BOOST_TEST_INCLUDED
#include <boost/test/data/test_case.hpp>
#include <boost/test/unit_test.hpp>

#include <boost/beast/http/verb.hpp>
#include <chrono>
#include <functional>
#include <iostream>
#include <thread>

#include "ApprovalTests.hpp"

#include "api/StoreApi.h"

#include "beast_client.h"


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
  auto storeApi = StoreApi(1234);
  std::shared_ptr<StoreApiStoreInventoryResource> res = std::make_shared<MyStoreApiStoreInventoryResource>();
  storeApi.setStoreApiStoreInventoryResource(res);

  std::thread thread([&]{
    storeApi.startService();
  });
  thread.detach();

  int status = 0;
  std::string data;

  // localhost:1234/v2/store/inventory/
  auto response = requestData(boost::beast::http::verb::get,
                          "/v2/store/inventory/");
  status = response.first;
  data = response.second;

  BOOST_TEST(200 == status);
  BOOST_TEST("Hello inventory" == data);

  // /store/order/{orderId: .*}/
  response = requestData(boost::beast::http::verb::get,
                                     "/v2/store/order/3");

  status = response.first;
  data = response.second;

  BOOST_TEST(501 == status);
  BOOST_TEST("Not implemented" == data);


  storeApi.stopService();
}

BOOST_AUTO_TEST_SUITE_END()