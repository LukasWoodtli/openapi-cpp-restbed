
add_executable(model_tests)

target_sources(model_tests
        PRIVATE
        main.cpp
        pet_model_test.cpp
        tag_model_test.cpp
        user_model_test.cpp
        category_model_test.cpp
        order_model_test.cpp
        api_response_model_test.cpp
        ../../generated_src/model/ApiResponse.cpp
        ../../generated_src/model/Category.cpp
        ../../generated_src/model/Order.cpp
        ../../generated_src/model/Pet.cpp
        ../../generated_src/model/Tag.cpp
        ../../generated_src/model/User.cpp
        )

target_include_directories(model_tests
        SYSTEM PRIVATE
            ${Boost_INCLUDE_DIRS}
            ../../generated_src
            ../approvaltests)
target_include_directories(model_tests PRIVATE ${CMAKE_CURRENT_LIST_DIR})

target_link_libraries(model_tests
        PRIVATE
            ${Boost_LIBRARIES})


add_test(NAME model_tests COMMAND model_tests)