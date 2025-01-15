package org.terraform

class CloneRepo {
    static void cloneRepo(String repoUrl, def steps) {
        steps.sh "git clone ${repoUrl}"
    }
}
