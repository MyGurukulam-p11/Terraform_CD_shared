import org.terraform.terraform_init

def call(def steps, String dir = '.') { 
    terraform_init.initTerraform(steps, dir)
}
