
include(FetchContent)

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




## nlohmann JSON
FetchContent_Declare(
        nlohmann
        GIT_REPOSITORY https://github.com/nlohmann/json.git
        GIT_TAG        master
)

FetchContent_MakeAvailable(nlohmann)

FetchContent_GetProperties(nlohmann)
if(NOT nlohmann_POPULATED)
    FetchContent_Populate(nlohmann)
    add_subdirectory(${nlohmann_SOURCE_DIR} ${nlohmann_BINARY_DIR})
endif()
