/*
 * @description statement always evaluates to true
 * 
 * */
package testcases.CWE571_Expression_Always_True;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;
import java.security.SecureRandom;
import java.util.Random;

public class CWE571_Expression_Always_True__class_getClass_not_equal_01 extends AbstractTestCase
{    
    public void bad()
    {
        /* FLAW: always evaluates to true */
        Random random = new Random();
        SecureRandom secureRandom = new SecureRandom();

        if (!random.getClass().equals(secureRandom.getClass()))
        {
            IO.writeLine("always prints");
        }
    }
}