package org.p11combinedforce.terraformCI

def call(String rootDir = "", String subDir = "", double costThreshold = 50.0) {
    stage('Infracost Breakdown') {
        withCredentials([string(credentialsId: 'infracost_key', variable: 'INFRACOST_API_KEY')]) {
            script {
    
                // Run Infracost breakdown and save the output to a JSON file
                sh '''
                    infracost breakdown --path=. --format=json --out-file=infracost_report.json
                '''
    
                // Get the total monthly cost from the JSON file
                def cost = sh(
                    script: "jq '.totalMonthlyCost' infracost_report.json",
                    returnStdout: true
                ).trim()
    
                // Print the total monthly cost
                echo "Total Monthly Cost: \$${cost}"
    
                def costValue = cost.replaceAll('"', '').toDouble()
    
                // Check if the cost exceeds the threshold
                if (costValue > costThreshold) {
                    error "Infracost: Total monthly cost exceeds \$${costThreshold}. Build failed."
                }
    
                // Archive the Infracost report
                archiveArtifacts artifacts: 'infracost_report.json', allowEmptyArchive: false
            }
        }
    }
}
