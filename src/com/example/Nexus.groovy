#!usr/bin/env groovy

package com.example

class Nexus implements Serializable {
    def script

    Nexus(script) {
        this.script = script
    }

    def nexusLoginPush(String imageName) {
        
        script.sh "echo Pushin to Nexus"
        script.withCredentials([usernamePassword(credentialsId: 'nexus-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin 159.203.37.16:8083"
        script.sh "docker tag $imageName 159.203.37.16:8083/$imageName"
        script.sh "docker push 159.203.37.16:8083/$imageName"
        
        }
   
    }

}