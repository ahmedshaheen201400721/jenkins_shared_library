#!/usr/bin/env groovy
def call(String ImageName) {
    echo "$BRANCH_NAME"
    sh " docker build -t  '127.0.0.1:8083/testimage':$ImageName  ."
}