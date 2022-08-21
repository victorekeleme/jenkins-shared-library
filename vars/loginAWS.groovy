#!usr/bin/env groovy
import com.example.AWS

def call() {
    return new AWS(this).loginAWSECR()
}
