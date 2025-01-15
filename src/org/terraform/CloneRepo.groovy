package org.terraform

class CloneRepo {
    static void cloneRepo(String repoUrl, def steps, String branch = 'main', String credentialsId = null) {
        try {
            steps.echo "Cloning repository: ${repoUrl} on branch: ${branch}"
            if (credentialsId) {
                steps.checkout([
                    $class: 'GitSCM',
                    branches: [[name: "*/${branch}"]],
                    userRemoteConfigs: [[url: repoUrl, credentialsId: credentialsId]]
                ])
            } else {
                steps.sh("git clone --branch ${branch} ${repoUrl}")
            }
        } catch (Exception e) {
            steps.error("Failed to clone repository: ${e.message}")
        }
    }
}package org.terraform

class CloneRepo {
    static void cloneRepo(String repoUrl, def steps) {
        steps.sh "git clone ${repoUrl}"
    }
}
