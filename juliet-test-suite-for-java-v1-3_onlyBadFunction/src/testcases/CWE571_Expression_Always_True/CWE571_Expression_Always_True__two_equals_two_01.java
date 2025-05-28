/*
 * @description statement always evaluates to true
 * 
 * */
package testcases.CWE571_Expression_Always_True;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE571_Expression_Always_True__two_equals_two_01 extends AbstractTestCase 
{
    public void bad()
    {
        /* FLAW: always evaluates to true */
        if (2 == 2)
        {
            IO.writeLine("always prints");
        }
    }
}