/*
 * @description statement always evaluates to false
 * 
 * */
package testcases.CWE570_Expression_Always_False;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE570_Expression_Always_False__private_01 extends AbstractTestCase 
{
    private boolean privateFalse = false;

    public void bad()
    {
        /* FLAW: always evaluates to false */
        if (privateFalse)
        {
            IO.writeLine("never prints");
        }
    }
}