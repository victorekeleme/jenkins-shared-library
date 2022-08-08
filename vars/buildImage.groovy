#!usr/bin/env groovy

def call() {
    echo "Building the application docker image"
    withCredentials([usernamePassword(credentialsId: 'Docker-Repo-Credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t vistein12/java-maven-app:${VERSION} ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push vistein12/java-maven-app:${VERSION}"
    }
}