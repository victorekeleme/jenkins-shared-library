#!usr/bin/env groovy
import com.example.Nexus

def call(String imageName) {
    sh "groovy --version"
    // return new Nexus(this).nexusLoginPush(imageName)
}