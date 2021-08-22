#!/usr/bin/env groovy
def call() {
    sh ' docker build -t  "127.0.0.1:8083/testimage":v2.2  .'
}