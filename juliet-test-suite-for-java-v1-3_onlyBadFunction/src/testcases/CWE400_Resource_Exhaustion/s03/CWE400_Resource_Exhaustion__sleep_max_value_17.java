/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__sleep_max_value_17.java
Label Definition File: CWE400_Resource_Exhaustion__sleep.label.xml
Template File: sources-sinks-17.tmpl.java
*/
/*
* @description
* CWE: 400 Resource Exhaustion
* BadSource: max_value Set count to a hardcoded value of Integer.MAX_VALUE
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks:
*    GoodSink: Validate count before using it as a parameter in sleep function
*    BadSink : Use count as the parameter for sleep withhout checking it's size first
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE400_Resource_Exhaustion.s03;
import testcasesupport.*;

public class CWE400_Resource_Exhaustion__sleep_max_value_17 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int count;

        /* We need to have one source outside of a for loop in order
         * to prevent the Java compiler from generating an error because
         * count is uninitialized
         */

        /* POTENTIAL FLAW: Set count to Integer.MAX_VALUE */
        count = Integer.MAX_VALUE;

        for (int j = 0; j < 1; j++)
        {
            /* POTENTIAL FLAW: Use count as the input to Thread.sleep() */
            Thread.sleep(count);
        }
    }
}