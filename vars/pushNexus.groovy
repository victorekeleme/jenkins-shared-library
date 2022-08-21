#!usr/bin/env groovy
// import com.example.Nexus

def call(String imageName) {
    sh "export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64"
    sh "echo $JAVA_HOME"
    sh "groovy --version"
    // return new Nexus(this).nexusLoginPush(imageName)
}