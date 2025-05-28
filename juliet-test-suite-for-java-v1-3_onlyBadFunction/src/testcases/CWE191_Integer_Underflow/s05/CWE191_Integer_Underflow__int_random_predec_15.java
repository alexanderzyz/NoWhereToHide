/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__int_random_predec_15.java
Label Definition File: CWE191_Integer_Underflow__int.label.xml
Template File: sources-sinks-15.tmpl.java
*/
/*
* @description
* CWE: 191 Integer Underflow
* BadSource: random Set data to a random value
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: decrement
*    GoodSink: Ensure there will not be an underflow before decrementing data
*    BadSink : Decrement data, which can cause an Underflow
* Flow Variant: 15 Control flow: switch(6) and switch(7)
*
* */

package testcases.CWE191_Integer_Underflow.s05;
import testcasesupport.*;

import javax.servlet.http.*;

import java.security.SecureRandom;

public class CWE191_Integer_Underflow__int_random_predec_15 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int data;

        switch (6)
        {
        case 6:
            /* POTENTIAL FLAW: Set data to a random value */
            data = (new SecureRandom()).nextInt();
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0;
            break;
        }

        switch (7)
        {
        case 7:
            /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
            int result = (int)(--data);
            IO.writeLine("result: " + result);
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        }
    }
}