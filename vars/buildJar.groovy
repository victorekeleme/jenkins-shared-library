#!usr/bin/env groovy

def call(){
    echo "Building application jar"
    sh "mvn clean package"
}
