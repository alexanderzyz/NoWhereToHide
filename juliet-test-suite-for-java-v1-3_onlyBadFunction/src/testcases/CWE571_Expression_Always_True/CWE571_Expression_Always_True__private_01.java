/*
 * @description statement always evaluates to true
 * 
 * */
package testcases.CWE571_Expression_Always_True;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE571_Expression_Always_True__private_01 extends AbstractTestCase 
{
    private boolean privateTrue = true;

    public void bad()
    {
        /* FLAW: always evaluates to true */
        if (privateTrue)
        {
            IO.writeLine("always prints");
        }
    }
}