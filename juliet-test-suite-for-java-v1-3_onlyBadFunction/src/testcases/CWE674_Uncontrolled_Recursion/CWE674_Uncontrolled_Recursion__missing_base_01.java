/*
 * @description uncontrolled recursion due to missing base or exit case
 *
 * */

package testcases.CWE674_Uncontrolled_Recursion;

import java.security.SecureRandom;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE674_Uncontrolled_Recursion__missing_base_01 extends AbstractTestCase 
{
    private static long helperBad(long level)
    {
        /* FLAW: Missing base case */
        long longSum = level + helperBad(level-1);
        return longSum;
    }
    
    public void bad()
    {
        long longSecureRandom = (new SecureRandom()).nextInt(100);
            
        IO.writeLine(helperBad(longSecureRandom));
    }
}