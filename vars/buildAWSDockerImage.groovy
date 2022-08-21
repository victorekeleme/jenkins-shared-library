#!usr/bin/env groovy

def call(String imageName) {
    return new AWS(this).buildAWSDockerImage(imageName)
}