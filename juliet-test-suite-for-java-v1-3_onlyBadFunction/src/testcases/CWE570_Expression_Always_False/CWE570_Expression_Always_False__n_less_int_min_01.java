/*
 * @description statement always evaluates to false
 * 
 * */
package testcases.CWE570_Expression_Always_False;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;
import java.security.SecureRandom;

public class CWE570_Expression_Always_False__n_less_int_min_01 extends AbstractTestCase 
{
    public void bad()
    {
        /* FLAW: always evaluates to false */
        int intSecureRandom = (new SecureRandom()).nextInt();
        if (intSecureRandom < Integer.MIN_VALUE)
        {
            IO.writeLine("never prints");
        }
    }
}