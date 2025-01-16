package org.terraform

class terraform_apply {
    static void applyTerraform(def steps, String dir = '.', boolean autoApprove = true) { 
        steps.sh """
        cd ${dir}
        terraform apply -var-file="dev.tfvars" ${autoApprove ? "-auto-approve" : ""}
        """
    }
}