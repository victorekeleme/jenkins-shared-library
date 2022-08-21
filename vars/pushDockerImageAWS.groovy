#!usr/bin/env groovy

def call(String imageName) {
    return new AWS(this).pushDockerImageAWS(imageName)
}