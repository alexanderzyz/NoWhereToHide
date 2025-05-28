/*
 * @description statement always evaluates to true
 * 
 * */
package testcases.CWE571_Expression_Always_True;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;
import java.security.SecureRandom;

public class CWE571_Expression_Always_True__n_less_int_max_01 extends AbstractTestCase 
{
    public void bad()
    {
        int intSecureRandom = (new SecureRandom()).nextInt();
        /* FLAW: always evaluates to true */
        if (intSecureRandom < Integer.MAX_VALUE)
        {
            IO.writeLine("always prints");
        }
    }
}