#!usr/bin/env groovy

def call() {
    echo "Building Jar"
    sh "mvn clean package"
}