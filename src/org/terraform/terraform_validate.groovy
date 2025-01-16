package org.terraform

class terraform_validate {
    static void validateTerraform(def steps, String dir = '.') { 
        steps.sh """
        cd ${dir} 
        terraform validate
        """
    }
}
