import org.terraform.terraform_plan

def call(def steps, String dir = '.') { 
    terraform_plan.planTerraform(steps, dir) 
}
