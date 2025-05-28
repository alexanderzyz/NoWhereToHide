/*
 * @description statement always evaluates to true
 * 
 * */
package testcases.CWE571_Expression_Always_True;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;
import java.security.SecureRandom;

public class CWE571_Expression_Always_True__n_equal_m_minus_one_01 extends AbstractTestCase 
{
    public void bad()
    {
        /* FLAW: always evaluates to true */
        int intThirty = 30;
        int intThirtyOne = 31;
        if (intThirty == (intThirtyOne - 1))
        {
            IO.writeLine("always prints");
        }
    }
}