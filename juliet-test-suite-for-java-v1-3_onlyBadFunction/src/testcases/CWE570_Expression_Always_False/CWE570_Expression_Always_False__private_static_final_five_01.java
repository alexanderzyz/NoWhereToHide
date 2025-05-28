/*
 * @description statement always evaluates to false
 * 
 * */
package testcases.CWE570_Expression_Always_False;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

import java.security.SecureRandom;

public class CWE570_Expression_Always_False__private_static_final_five_01 extends AbstractTestCase 
{
    private static final int PRIVATE_STATIC_FINAL_FIVE = 5;

    public void bad()
    {
        /* FLAW: always evaluates to false */
        if (PRIVATE_STATIC_FINAL_FIVE != 5)
        {
            IO.writeLine("never prints");
        }
    }
}