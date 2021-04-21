#!/bin/bash

set -u
set -e

#wget https://github.com/OpenAPITools/openapi-generator/blob/v5.1.0/bin/utils/openapi-generator-cli.sh

export OPENAPI_GENERATOR_VERSION=5.1.0

generator_cmd=./openapi-generator-cli.sh

$generator_cmd version

# Extract templates from jar
# $generator_cmd author template -g cpp-restbed-server

$generator_cmd generate -i petstore.yaml -g cpp-restbed-server -o restbed/generated_src -t cpp_restbed_server_custom_templates

#$generator_cmd generate -i petstore.yaml -g java -o java_client/generated_src
