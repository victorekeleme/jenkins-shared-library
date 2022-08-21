#!usr/bin/env groovy

def call() {
    sh "echo Building application jar"
    sh "mvn clean package"
}

