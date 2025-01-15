import org.terraform.terraform_validate

def call(def steps, String dir = '.') { 
    terraform_validate.validateTerraform(steps, dir) 
}
