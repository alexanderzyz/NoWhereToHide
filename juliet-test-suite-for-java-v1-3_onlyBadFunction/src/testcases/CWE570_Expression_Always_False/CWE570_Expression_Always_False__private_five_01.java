/*
 * @description statement always evaluates to false
 * 
 * */
package testcases.CWE570_Expression_Always_False;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

import java.security.SecureRandom;

public class CWE570_Expression_Always_False__private_five_01 extends AbstractTestCase 
{
    private int privateFive = 5;

    public void bad()
    {
        /* FLAW: always evaluates to false */
        if (privateFive != 5)
        {
            IO.writeLine("never prints");
        }
    }
}