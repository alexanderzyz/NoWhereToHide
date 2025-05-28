/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__short_min_sub_31.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-31.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: min Set data to the max value for short
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: sub
 *    GoodSink: Ensure there will not be an underflow before subtracting 1 from data
 *    BadSink : Subtract 1 from data, which can cause an Underflow
 * Flow Variant: 31 Data flow: make a copy of data within the same method
 *
 * */

package testcases.CWE191_Integer_Underflow.s03;
import testcasesupport.*;

public class CWE191_Integer_Underflow__short_min_sub_31 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        short dataCopy;
        {
            short data;

            /* POTENTIAL FLAW: Use the maximum size of the data type */
            data = Short.MIN_VALUE;

            dataCopy = data;
        }
        {
            short data = dataCopy;

            /* POTENTIAL FLAW: if data == Short.MIN_VALUE, this will overflow */
            short result = (short)(data - 1);

            IO.writeLine("result: " + result);

        }
    }
}