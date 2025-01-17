package org.p11combinedforce.terraformCI

def call(String rootDir="", String subDir="") {
    stage("run tflint") {
        script {
            def dirPath = "${rootDir}/${subDir}"
            dir(dirPath) {
                sh "tflint --format json > tflint_report.json || true"
                archiveArtifacts artifacts: 'tflint_report.json', allowEmptyArchive: true
            }
        }
    }
}