/*
 * @description Recursion not limited to a managed level
 *
 * */

package testcases.CWE674_Uncontrolled_Recursion;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE674_Uncontrolled_Recursion__long_01 extends AbstractTestCase 
{
    private static final long RECURSION_LONG_MAX = 10;

    private static void helperBad(long level)
    {
        /* FLAW: Although this cannot cause "infinite" recursion, it is essentially limited to Long.MAX_VALUE
         * which is rather large */
        if (level == 0) 
        {
            return;
        }

        helperBad(level - 1);
    }
    
    public void bad()
    {
        long longMax = Long.MAX_VALUE;
            
        helperBad(longMax);
    }
}