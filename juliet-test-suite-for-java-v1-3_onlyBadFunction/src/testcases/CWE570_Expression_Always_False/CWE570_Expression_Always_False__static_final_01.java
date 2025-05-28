/*
 * @description statement always evaluates to false
 * 
 * */
package testcases.CWE570_Expression_Always_False;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE570_Expression_Always_False__static_final_01 extends AbstractTestCase 
{
    public void bad()
    {
        /* FLAW: always evaluates to false */
        if (IO.STATIC_FINAL_FALSE)
        {
            IO.writeLine("never prints");
        }
    }
}