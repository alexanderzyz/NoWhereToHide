/*
 * @description statement always evaluates to false
 * 
 * */
package testcases.CWE570_Expression_Always_False;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

import java.security.SecureRandom;

public class CWE570_Expression_Always_False__static_five_01 extends AbstractTestCase 
{
    public void bad()
    {
        /* FLAW: always evaluates to false */
        if (IO.staticFive != 5)
        {
            IO.writeLine("never prints");
        }
    }
}