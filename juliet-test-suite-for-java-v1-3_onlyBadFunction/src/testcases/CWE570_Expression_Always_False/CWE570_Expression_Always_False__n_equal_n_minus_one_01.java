/*
 * @description statement always evaluates to false
 * 
 * */
package testcases.CWE570_Expression_Always_False;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;
import java.security.SecureRandom;

public class CWE570_Expression_Always_False__n_equal_n_minus_one_01 extends AbstractTestCase 
{
    public void bad()
    {
        /* FLAW: always evaluates to false */
        int intThirty = 30;

        if (intThirty == (intThirty - 1))
        {
            IO.writeLine("never prints");
        }
    }
}