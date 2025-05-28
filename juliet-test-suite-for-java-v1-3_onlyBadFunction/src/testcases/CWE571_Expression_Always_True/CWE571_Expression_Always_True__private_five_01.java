/*
 * @description statement always evaluates to true
 * 
 * */
package testcases.CWE571_Expression_Always_True;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

import java.security.SecureRandom;

public class CWE571_Expression_Always_True__private_five_01 extends AbstractTestCase 
{
    private int privateFive = 5;
    
    public void bad()
    {
        /* FLAW: always evaluates to true */
        if (privateFive == 5)
        {
            IO.writeLine("always prints");
        }
    }
}