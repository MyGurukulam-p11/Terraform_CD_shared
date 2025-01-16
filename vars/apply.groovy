import org.terraform.terraform_apply

def call(def steps, String dir = '.', boolean autoApprove = true) { 
    terraform_apply.applyTerraform(steps, dir, autoApprove) 
}
