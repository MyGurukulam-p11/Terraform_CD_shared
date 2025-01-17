package org.p11combinedforce.terraformCI

def call(String rootDir="", String subDir=""){
    stage("terraform fmt"){
        script{
    
            def dirPath = "${rootDir}/${subDir}"
            dir(dirPath) {
                sh "terraform fmt"
            }
        }
    }
}
