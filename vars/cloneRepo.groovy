import org.terraform.CloneRepo

def call(String repoUrl) {
    new CloneRepo().cloneRepo(repoUrl, this)
}
