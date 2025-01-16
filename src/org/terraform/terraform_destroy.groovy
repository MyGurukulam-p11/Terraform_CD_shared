package org.terraform

class terraform_destroy {
    static void destroyTerraform(def steps, String dir = '.', boolean autoApprove = true) { 
        steps.sh """
        cd ${dir}
        terraform destroy -var-file="dev.tfvars" ${autoApprove ? "-auto-approve" : ""}
        """
    }
}
