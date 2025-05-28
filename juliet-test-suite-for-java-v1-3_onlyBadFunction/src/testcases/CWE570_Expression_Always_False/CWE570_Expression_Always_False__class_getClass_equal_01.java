/*
 * @description statement always evaluates to false
 * 
 * */
package testcases.CWE570_Expression_Always_False;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;
import java.security.SecureRandom;
import java.util.Random;

public class CWE570_Expression_Always_False__class_getClass_equal_01 extends AbstractTestCase
{    
    public void bad()
    {
        /* FLAW: always evaluates to false */
        Random random = new Random();
        SecureRandom secureRandom = new SecureRandom();

        if (random.getClass().equals(secureRandom.getClass()))
        {
            IO.writeLine("never prints");
        }
    }
}