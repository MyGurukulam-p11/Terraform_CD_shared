package org.p11combinedforce.terraformCI

def call(String rootDir="", String subDir=""){
    stage("terraform validate"){
        script{
    
            def dirPath = "${rootDir}/${subDir}"
            dir(dirPath) {
                sh "terraform validate"
            }
        }
    }
}
