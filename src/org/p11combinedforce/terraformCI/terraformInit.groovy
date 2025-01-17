package org.p11combinedforce.terraformCI

def call(String rootDir="", String subDir=""){
    stage("terraform init"){
        script{
            def dirPath = "${rootDir}/${subDir}"
            dir(dirPath) {
                sh "terraform init"
            }
        }
    }
}
