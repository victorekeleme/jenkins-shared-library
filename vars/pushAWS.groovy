#!usr/bin/env groovy

def call(String IMAGE_NAME) {
    echo "Pushing Docker Image to AWS"

    withCredentials([aws(accessKeyVariable:'AWS_ACCESS_KEY_ID',credentialsId:'aws-credentials',secretKeyVariable:'AWS_SECRET_ACCESS_KEY')]) {
        sh "aws ecr get-login-password --region us-east-2 | docker login --username AWS --password-stdin 524360703326.dkr.ecr.us-east-2.amazonaws.com"
        sh "docker build -t $IMAGE_NAME ." 
        sh "docker tag $IMAGE_NAME 524360703326.dkr.ecr.us-east-2.amazonaws.com/$IMAGE_NAME"
        sh "docker push 524360703326.dkr.ecr.us-east-2.amazonaws.com/$IMAGE_NAME"
    }

}
