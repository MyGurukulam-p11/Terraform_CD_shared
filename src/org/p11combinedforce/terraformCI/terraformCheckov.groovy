package org.p11combinedforce.terraformCI

def call(String rootDir="", String subDir="") {
    stage("run checkov") {
        script {
            def dirPath = "${rootDir}/${subDir}"
            dir(dirPath) {
                // Ensure the PATH modification applies to all commands in this block
                sh '''export PATH=$PATH:/var/lib/jenkins/.local/bin
                     checkov --version
                     checkov -d .  --output-file checkov_report.html || true
                     '''
                    archiveArtifacts artifacts: 'checkov_report.html/*', allowEmptyArchive: true 
            }
        }
    }
}
