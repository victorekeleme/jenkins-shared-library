#!usr/bin/env groovy

def call(String imageName) {
    echo "Building Docker Image"
    sh "docker build -t vistein12/$imageName ."

    withCredentials([usernamePassword(credentialsId:'docker-credentials', passwordVariable:'PASS', usernameVariable:'USER')]){
        sh "echo $PASS | docker login -u $USER --password-stdin"
    }
    sh "docker push vistein12/$imageName"

}