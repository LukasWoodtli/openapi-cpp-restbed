
include(dependencies.cmake)

file(GLOB_RECURSE
        GENERATED_SOURCES
        CONFIGURE_DEPENDS
        "*.cpp" "*.h")


add_executable(pistache_server)
target_include_directories(pistache_server
        SYSTEM PRIVATE
        ${nlohmann_SOURCE_DIR}/include
        ${pistache_SOURCE_DIR}/include)
target_sources(pistache_server PRIVATE ${GENERATED_SOURCES})
