/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__long_min_postdec_45.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-45.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: min Set data to the max value for long
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: decrement
 *    GoodSink: Ensure there will not be an underflow before decrementing data
 *    BadSink : Decrement data, which can cause an Underflow
 * Flow Variant: 45 Data flow: data passed as a private class member variable from one function to another in the same class
 *
 * */

package testcases.CWE191_Integer_Underflow.s04;
import testcasesupport.*;

public class CWE191_Integer_Underflow__long_min_postdec_45 extends AbstractTestCase
{
    private long dataBad;
    private long dataGoodG2B;
    private long dataGoodB2G;

    private void badSink() throws Throwable
    {
        long data = dataBad;

        /* POTENTIAL FLAW: if data == Long.MIN_VALUE, this will overflow */
        data--;
        long result = (long)(data);

        IO.writeLine("result: " + result);

    }

    public void bad() throws Throwable
    {
        long data;

        /* POTENTIAL FLAW: Use the maximum size of the data type */
        data = Long.MIN_VALUE;

        dataBad = data;
        badSink();
    }
}