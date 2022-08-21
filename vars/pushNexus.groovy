#!usr/bin/env groovy

def call(String imageName) {
    sh "echo Pushin to Nexus"

    withCredentials([usernamePassword(credentialsId: 'nexus-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
    sh "echo $PASS | docker login -u $USER --password-stdin 159.203.37.16:8083"
    sh "docker tag $imageName 159.203.37.16:8083/$imageName"
    sh "docker push 159.203.37.16:8083/$imageName"
    }

}
