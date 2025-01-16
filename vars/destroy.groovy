import org.terraform.terraform_destroy

def call(def steps, String dir = '.', boolean autoApprove = true) { 
    terraform_destroy.destroyTerraform(steps, dir, autoApprove) 
}
