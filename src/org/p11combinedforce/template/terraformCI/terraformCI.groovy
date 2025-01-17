package org.p11combinedforce.terraformCI

import org.p11combinedforce.terraformCI.*
import org.p11combinedforce.common.*
import org.p11combinedforce.genernicCI.*

def call(String url, String branch, String creds, String rootDir = "", String subDir = "") {

    // Create instances of required classes
    def gitCheckOut = new gitCheckOut()
    def terraformCheckov = new terraformCheckov()
    def terraformLflint = new terraformLflint()
    def terraformInit = new terraformInit()
    def terraformFmt = new terraformFmt()
    def terraformValidate = new terraformValidate()
    def terraformInfracost=new terraformInfracost()
    def wsClean=new wsClean()

    // Call methods with correct arguments
    wsClean.call()
    gitCheckOut.call(url, branch, creds)
    terraformInit.call(rootDir, subDir)
    terraformFmt.call(rootDir, subDir)
    terraformValidate.call(rootDir, subDir)
    terraformLflint.call(rootDir, subDir)
    terraformCheckov.call(rootDir, subDir)
    terraformInfracost(rootDir,subDir)
}
