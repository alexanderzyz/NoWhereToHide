/*
 * @description Explicitly throw an Error that will not be caught by any code and the JVM will halt.  Unfortunately the design of our test cases don't let us throw an Exception (runTest() in AbstractTestCase is not declared as throwing anything and adding a throw cascades to updates to all test case files).
 *
 * */

package testcases.CWE248_Uncaught_Exception;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;
import java.util.logging.Level;

public class CWE248_Uncaught_Exception__Error_01 extends AbstractTestCase 
{
    public void bad() 
    {
        /* FLAW: Error not caught */
        throw new Error("Really bad Error");
    }
}