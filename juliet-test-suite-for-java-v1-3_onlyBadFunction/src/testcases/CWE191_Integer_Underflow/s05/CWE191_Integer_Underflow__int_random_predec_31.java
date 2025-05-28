/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__int_random_predec_31.java
Label Definition File: CWE191_Integer_Underflow__int.label.xml
Template File: sources-sinks-31.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: random Set data to a random value
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: decrement
 *    GoodSink: Ensure there will not be an underflow before decrementing data
 *    BadSink : Decrement data, which can cause an Underflow
 * Flow Variant: 31 Data flow: make a copy of data within the same method
 *
 * */

package testcases.CWE191_Integer_Underflow.s05;
import testcasesupport.*;

import javax.servlet.http.*;

import java.security.SecureRandom;

public class CWE191_Integer_Underflow__int_random_predec_31 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int dataCopy;
        {
            int data;

            /* POTENTIAL FLAW: Set data to a random value */
            data = (new SecureRandom()).nextInt();

            dataCopy = data;
        }
        {
            int data = dataCopy;

            /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
            int result = (int)(--data);

            IO.writeLine("result: " + result);

        }
    }
}