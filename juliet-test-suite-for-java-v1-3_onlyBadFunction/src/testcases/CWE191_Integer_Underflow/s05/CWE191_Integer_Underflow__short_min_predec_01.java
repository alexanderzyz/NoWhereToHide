/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__short_min_predec_01.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-01.tmpl.java
*/
/*
* @description
* CWE: 191 Integer Underflow
* BadSource: min Set data to the max value for short
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: decrement
*    GoodSink: Ensure there will not be an underflow before decrementing data
*    BadSink : Decrement data, which can cause an Underflow
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE191_Integer_Underflow.s05;
import testcasesupport.*;

public class CWE191_Integer_Underflow__short_min_predec_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        short data;

        /* POTENTIAL FLAW: Use the maximum size of the data type */
        data = Short.MIN_VALUE;

        /* POTENTIAL FLAW: if data == Short.MIN_VALUE, this will overflow */
        short result = (short)(--data);

        IO.writeLine("result: " + result);

    }
}