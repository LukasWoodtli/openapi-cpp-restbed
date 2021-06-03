
include(dependencies.cmake)


set(GENERATED_SOURCES
    generated_src/model/Pet.cpp
    generated_src/model/Tag.h
    generated_src/model/ApiResponse.cpp
    generated_src/model/ApiResponse.h
    generated_src/model/Tag.cpp
    generated_src/model/Order.h
    generated_src/model/User.h
    generated_src/model/Category.h
    generated_src/model/User.cpp
    generated_src/model/Category.cpp
    generated_src/model/Pet.h
    generated_src/model/Order.cpp
    generated_src/api/PetApi.cpp
    generated_src/api/StoreApi.h
    generated_src/api/UserApi.cpp
    generated_src/api/StoreApi.cpp
    generated_src/api/PetApi.h
    generated_src/api/UserApi.h
)

set(GENERATED_SOURCES_INCLUDE_DIRS
        generated_src/api
        generated_src/model)

add_library(restbed_example SHARED)

target_include_directories(restbed_example
        SYSTEM PUBLIC
            ${restbed_SOURCE_DIR}/source)
target_include_directories(restbed_example
        PUBLIC
            generated_src
            ${GENERATED_SOURCES_INCLUDE_DIRS})

target_sources(restbed_example
        PRIVATE
        ${GENERATED_SOURCES}
        main.cpp)

target_link_libraries(restbed_example
        PUBLIC
            Boost::system
            restbed-shared)

add_subdirectory(test)