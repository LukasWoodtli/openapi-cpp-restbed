cmake_policy(SET CMP0048 NEW)

project(cpp-open-api VERSION 1)
cmake_minimum_required(VERSION 3.18)

set(CMAKE_CXX_STANDARD 17)

enable_testing()

add_subdirectory(restbed)
