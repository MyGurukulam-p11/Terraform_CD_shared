package org.terraform

class terraform_fmt {
    static void fmtTerraform(def steps, String dir = '.') { 
        steps.sh """
        cd ${dir} 
        terraform fmt
        """
    }
}
