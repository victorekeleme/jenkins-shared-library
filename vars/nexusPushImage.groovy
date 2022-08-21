#!usr/bin/env groovy
import com.example.Nexus

def call(String imageName) {
    return new Nexus(this).nexusPush(imageName)
}