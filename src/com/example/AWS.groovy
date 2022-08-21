#!usr/bin/env groovy

package com.example

class AWS implements Serializable {
    def script

    AWS(script) {
        this.script = script
    }
    def loginAWS() {
        withCredentials([aws(accessKeyVariable:'AWS_ACCESS_KEY_ID',credentialsId:'aws-credentials',secretKeyVariable:'AWS_SECRET_ACCESS_KEY')]) {
        sh "aws ecr get-login-password --region us-east-2 | docker login --username AWS --password-stdin 524360703326.dkr.ecr.us-east-2.amazonaws.com"
    }
    def buildDockerImage(String imageName) {
       sh "docker build -t $imageName ."

    }
    def pushDockerImageAWS(String imageName) {
        sh "docker tag $imageName 524360703326.dkr.ecr.us-east-2.amazonaws.com/$imageName"
        sh "docker push 524360703326.dkr.ecr.us-east-2.amazonaws.com/$imageName"
    }
   
}