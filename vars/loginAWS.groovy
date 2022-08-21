#!usr/bin/env groovy

def call() {
    return  new AWS(this).loginAWS()
}
