#!usr/bin/env groovy

def call(String IMAGE_NAME) {
    sh "echo Pushin to Nexus"

    withCredentials([usernamePassword(credentialsId: 'nexus-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
    sh "echo $PASS | docker login -u $USER --password-stdin 159.203.37.16:8083"
    sh "docker tag $IMAGE_NAME 159.203.37.16:8083/$IMAGE_NAME"
    sh "docker push 159.203.37.16:8083/$IMAGE_NAME"
    }

}
