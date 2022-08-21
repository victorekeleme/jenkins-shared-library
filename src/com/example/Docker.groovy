
#!usr/bin/env groovy
package com.example

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "Building the application docker image"
        script.sh "docker build -t $imageName ."
    }

    def login() {
        script.withCredentials([script.usernamePassword(credentialsId: 'Docker-Repo-Credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
        }
    }

    def pushDockerImage(String imageName) {
        script.sh "docker push $imageName"
    }        

}