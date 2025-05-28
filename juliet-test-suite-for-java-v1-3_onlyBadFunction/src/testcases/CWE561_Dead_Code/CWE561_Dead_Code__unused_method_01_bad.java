/*
 * @description Bad class never uses the private function calculation, therefore, it is dead code.
 * 
 * */
package testcases.CWE561_Dead_Code;

import testcasesupport.AbstractTestCaseClassIssueBad;
import testcasesupport.IO;

public class CWE561_Dead_Code__unused_method_01_bad extends AbstractTestCaseClassIssueBad 
{
    /* FLAW: This method is never called */
    private String calculation()
    {
        return "Calculation";
    }
    
    public void bad() throws Throwable 
    {
        IO.writeLine("hello");
    }
}