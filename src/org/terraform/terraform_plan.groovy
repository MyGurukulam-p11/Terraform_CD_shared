package org.terraform

class terraform_plan {
    static void planTerraform(def steps, String dir = '.') { 
        steps.sh """
        cd ${dir}
        terraform plan -var-file="dev.tfvars"
        """
    }
}
