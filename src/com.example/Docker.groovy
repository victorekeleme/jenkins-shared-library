#!usr/bin/env groovy
package com.example

class Docker implements Serialiazable {

    def script

    def Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "Building the application docker image"
        script.withCredentials([script.usernamePassword(credentialsId: 'Docker-Repo-Credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        script.sh "docker build -t $imageName ."
        script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
        script.sh "docker push $imageName"
        }

    }

}