
add_executable(api_tests)

target_sources(api_tests
        PRIVATE
        main.cpp
        store_api_test.cpp
        beast_client.cpp
        ../../generated_src/api/StoreApi.cpp
        ../../generated_src/model/Order.cpp
        )

target_include_directories(api_tests
        SYSTEM PRIVATE
        ${Boost_INCLUDE_DIRS}
        ../../generated_src
        ../approvaltests
        ${restbed_SOURCE_DIR}/source
        )
target_include_directories(api_tests
        PRIVATE
            ${CMAKE_CURRENT_LIST_DIR}
            ../../generated_src/model
        )

target_link_libraries(api_tests
        PRIVATE
        ${Boost_LIBRARIES}
        restbed-shared
        )

message(WARNING "'api_tests' currently disabled due to problem on circleci")
#add_test(NAME api_tests COMMAND api_tests)
