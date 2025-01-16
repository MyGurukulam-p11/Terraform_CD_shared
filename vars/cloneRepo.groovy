import org.terraform.common.CloneRepo

def call(Map config, String repoUrl) {
    def branch = config.get('branch', 'main') 
    def credentialsId = config.get('credentialsId', null) 
    org.terraform.CloneRepo.cloneRepo(repoUrl, this, branch, credentialsId)
}
