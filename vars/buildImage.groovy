#!usr/bin/env groovy

def call(String IMAGE_NAME) {
    echo "Building Docker Image"
    sh "docker build -t vistein12/$IMAGE_NAME ."

    withCredentials([usernamePassword(credentialsId:'docker-credentials', passwordVariable:'PASS', usernameVariable:'USER')]){
        sh "echo $PASS | docker login -u $USER --password-stdin"
    }
    sh "docker push vistein12/$IMAGE_NAME"

}