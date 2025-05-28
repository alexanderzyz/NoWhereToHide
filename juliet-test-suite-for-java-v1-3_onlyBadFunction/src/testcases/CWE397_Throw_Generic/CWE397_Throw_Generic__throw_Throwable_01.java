/*
 * @description Throw an overly-broad exception (in this case, Throwable).  This is a manual test case because generated test cases are all in methods that throw Throwable and we want to avoid that since it is related to this CWE.
 *
 * */

package testcases.CWE397_Throw_Generic;

import testcasesupport.AbstractTestCase;
import java.io.FileNotFoundException;

public class CWE397_Throw_Generic__throw_Throwable_01 extends AbstractTestCase 
{
    public void bad() throws Throwable 
    {
        throw new Throwable(); /* FLAW: Throw Throwable, which is very generic */ 
    }
}