project(restbed-open-api)

cmake_minimum_required(VERSION 3.18)

include(FetchContent)

## Restbed
FetchContent_Declare(
  restbed
  GIT_REPOSITORY https://github.com/Corvusoft/restbed
  GIT_TAG        4.7
)

FetchContent_MakeAvailable(restbed)

FetchContent_GetProperties(restbed)
if(NOT restbed_POPULATED)
  FetchContent_Populate(restbed)
  add_subdirectory(${restbed_SOURCE_DIR} ${restbed_BINARY_DIR})
endif()


## Pistache
FetchContent_Declare(
  pistache
  GIT_REPOSITORY https://github.com/pistacheio/pistache
  GIT_TAG        master
)

FetchContent_MakeAvailable(pistache)

FetchContent_GetProperties(pistache)
if(NOT pistache_POPULATED)
  FetchContent_Populate(pistache)
  add_subdirectory(${pistache_SOURCE_DIR} ${pistache_BINARY_DIR})
endif()