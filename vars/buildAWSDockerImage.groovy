#!usr/bin/env groovy
import com.example.AWS

def call(String imageName) {
    return new AWS(this).buildAWSDockerImage(imageName)
}