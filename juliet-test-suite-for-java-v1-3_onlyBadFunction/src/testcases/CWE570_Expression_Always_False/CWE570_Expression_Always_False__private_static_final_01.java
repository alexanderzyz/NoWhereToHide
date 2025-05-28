/*
 * @description statement always evaluates to false
 * 
 * */
package testcases.CWE570_Expression_Always_False;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE570_Expression_Always_False__private_static_final_01 extends AbstractTestCase 
{
    private static final boolean PRIVATE_STATIC_FINAL_FALSE = false;

    public void bad()
    {
        /* FLAW: always evaluates to false */
        if (PRIVATE_STATIC_FINAL_FALSE)
        {
            IO.writeLine("never prints");
        }
    }
}