package com.example
class Docker implements Serialzable {
    def script

    Docker(script){
        this.script=script
    }
    def buildDockerImage(String imageName){
        script.echo "$script.BRANCH_NAME"
        script.sh " docker build -t  '127.0.0.1:8083/testimage':$ImageName  ."
    }
}