/*
 * @description statement always evaluates to true
 * 
 * */
package testcases.CWE571_Expression_Always_True;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE571_Expression_Always_True__static_final_01 extends AbstractTestCase 
{
    public void bad()
    {
        /* FLAW: always evaluates to true */
        if (IO.STATIC_FINAL_TRUE)
        {
            IO.writeLine("always prints");
        }
    }
}