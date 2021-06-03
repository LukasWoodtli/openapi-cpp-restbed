
add_executable(default_handlers_test_server)

target_sources(default_handlers_test_server
        PRIVATE main.cpp)

target_link_libraries(default_handlers_test_server restbed_example)