if (CMAKE_CXX_COMPILER_ID STREQUAL "Clang")
    set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -fprofile-instr-generate -fcoverage-mapping")
    set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -fprofile-instr-generate -fcoverage-mapping")
elseif (CMAKE_CXX_COMPILER_ID STREQUAL "GNU")
    set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} --coverage")
    set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} --coverage")
endif()

add_executable(model_tests)

target_sources(model_tests
        PRIVATE
        main.cpp
        pet_model_test.cpp
        tag_model_test.cpp
        user_model_test.cpp
        category_model_test.cpp
        order_model_test.cpp
        ../generated_src/model/Pet.cpp
        ../generated_src/model/Tag.cpp
        ../generated_src/model/Category.cpp
        ../generated_src/model/User.cpp
        ../generated_src/model/Order.cpp
)

target_include_directories(model_tests SYSTEM PRIVATE ${Boost_INCLUDE_DIRS})
target_include_directories(model_tests PRIVATE ${CMAKE_CURRENT_LIST_DIR})

target_link_libraries(model_tests ${Boost_LIBRARIES})

add_test(NAME model_tests COMMAND model_tests)