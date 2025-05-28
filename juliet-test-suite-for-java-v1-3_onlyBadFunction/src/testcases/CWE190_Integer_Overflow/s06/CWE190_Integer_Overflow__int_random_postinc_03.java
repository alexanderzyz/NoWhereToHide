/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__int_random_postinc_03.java
Label Definition File: CWE190_Integer_Overflow__int.label.xml
Template File: sources-sinks-03.tmpl.java
*/
/*
* @description
* CWE: 190 Integer Overflow
* BadSource: random Set data to a random value
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: increment
*    GoodSink: Ensure there will not be an overflow before incrementing data
*    BadSink : Increment data, which can cause an overflow
* Flow Variant: 03 Control flow: if(5==5) and if(5!=5)
*
* */

package testcases.CWE190_Integer_Overflow.s06;
import testcasesupport.*;

import javax.servlet.http.*;

import java.security.SecureRandom;

public class CWE190_Integer_Overflow__int_random_postinc_03 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int data;
        if (5==5)
        {
            /* POTENTIAL FLAW: Set data to a random value */
            data = (new SecureRandom()).nextInt();
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0;
        }

        if (5==5)
        {
            /* POTENTIAL FLAW: if data == Integer.MAX_VALUE, this will overflow */
            data++;
            int result = (int)(data);
            IO.writeLine("result: " + result);
        }
    }
}