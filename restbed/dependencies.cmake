

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

find_package(Boost COMPONENTS system)
