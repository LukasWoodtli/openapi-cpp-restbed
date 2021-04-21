
include(dependencies.cmake)


file(GLOB_RECURSE
        GENERATED_SOURCES
        CONFIGURE_DEPENDS
        "*.cpp" "*.h")

set(GENERATED_SOURCES_INCLUDE_DIRS
        generated_src/api
        generated_src/model)

add_executable(restbed_server)

target_include_directories(restbed_server
        SYSTEM PRIVATE
        ${restbed_SOURCE_DIR}/source)
target_include_directories(restbed_server
        PRIVATE
        ${GENERATED_SOURCES_INCLUDE_DIRS})

target_sources(restbed_server PRIVATE ${GENERATED_SOURCES})

target_link_libraries(restbed_server PRIVATE Boost::system)
