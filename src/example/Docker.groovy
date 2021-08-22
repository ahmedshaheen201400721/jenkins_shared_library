
package example

class Docker implements Serializable {
    def script

    Docker(script){
        this.script=script
    }
    def buildDockerImage(String ImageName){
        script.echo "$script.BRANCH_NAME"
        script.sh " docker build -t  '127.0.0.1:8083/testimage':$ImageName  ."
    }
    def pushDockerImage(String ImageName){
         script.withCredentials([script.usernamePassword(credentialsId:"nexus",usernameVariable: "USER", passwordVariable: "pass")]){
            script.sh " echo $script.pass |docker login -u $script.USER --password-stdin http://127.0.0.1:8083"
        }
     script.sh "docker push '127.0.0.1:8083/testimage':$ImageName"
    }
}