import org.terraform.terraform_fmt

def call(def steps, String dir = '.') { 
    terraform_fmt.fmtTerraform(steps, dir)
}
