#!usr/bin/env groovy
def call(String imageName) {
    echo "Pushing Docker Image to AWS"

    withCredentials([aws(accessKeyVariable:'AWS_ACCESS_KEY_ID',credentialsId:'aws-credentials',secretKeyVariable:'AWS_SECRET_ACCESS_KEY')]) {
        sh "aws ecr get-login-password --region us-east-2 | docker login --username AWS --password-stdin 524360703326.dkr.ecr.us-east-2.amazonaws.com"
        sh "docker build -t $imageName ." 
        sh "docker tag $imageName 524360703326.dkr.ecr.us-east-2.amazonaws.com/$imageName"
        sh "docker push 524360703326.dkr.ecr.us-east-2.amazonaws.com/$imageName"
    }

}