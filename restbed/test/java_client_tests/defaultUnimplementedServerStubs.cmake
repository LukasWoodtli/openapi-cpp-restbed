
add_custom_target(run_all_java_client_test_for_cpp_server)

set(RUN_CLIENT_TESTS_SHELL_TEMPLATE "${CMAKE_CURRENT_SOURCE_DIR}/run_java_client_tests_template.txt")

function(run_java_client_test_for_cpp_server TARGET_NAME)
    set(TEST_SERVER_EXECUTABLE "${CMAKE_CURRENT_BINARY_DIR}/${TARGET_NAME}")

    set(RUN_TESTS_TARGET run_${TARGET_NAME}_test)
    configure_file(${RUN_CLIENT_TESTS_SHELL_TEMPLATE}
            ${CMAKE_CURRENT_BINARY_DIR}/${RUN_TESTS_TARGET}.sh
            @ONLY)

    add_custom_target(${RUN_TESTS_TARGET}
            COMMAND ${CMAKE_CURRENT_BINARY_DIR}/${RUN_TESTS_TARGET}.sh
            DEPENDS ${TARGET_NAME}
            USES_TERMINAL
            COMMENT "Running tests: ${TARGET_NAME}")

    add_dependencies(run_all_java_client_test_for_cpp_server ${RUN_TESTS_TARGET})
endfunction()
