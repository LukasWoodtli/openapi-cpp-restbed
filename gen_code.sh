#!/bin/bash

set -u
set -e

#curl https://github.com/OpenAPITools/openapi-generator/blob/v5.1.0/bin/utils/openapi-generator-cli.sh -o openapi-generator-cli.sh

export OPENAPI_GENERATOR_VERSION=5.1.0

genertator_cmd=./openapi-generator-cli.sh

$genertator_cmd version
$genertator_cmd generate -i petstore.yaml -g cpp-pistache-server -o pistache/generated_src
$genertator_cmd generate -i petstore.yaml -g cpp-restbed-server -o restbed/generated_src