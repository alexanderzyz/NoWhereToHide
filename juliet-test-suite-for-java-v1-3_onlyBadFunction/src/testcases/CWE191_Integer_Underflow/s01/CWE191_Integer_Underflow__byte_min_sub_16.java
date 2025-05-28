/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__byte_min_sub_16.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 191 Integer Underflow
* BadSource: min Set data to the max value for byte
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: sub
*    GoodSink: Ensure there will not be an underflow before subtracting 1 from data
*    BadSink : Subtract 1 from data, which can cause an Underflow
* Flow Variant: 16 Control flow: while(true)
*
* */

package testcases.CWE191_Integer_Underflow.s01;
import testcasesupport.*;

public class CWE191_Integer_Underflow__byte_min_sub_16 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        byte data;

        while (true)
        {
            /* POTENTIAL FLAW: Use the maximum size of the data type */
            data = Byte.MIN_VALUE;
            break;
        }

        while (true)
        {
            /* POTENTIAL FLAW: if data == Byte.MIN_VALUE, this will overflow */
            byte result = (byte)(data - 1);
            IO.writeLine("result: " + result);
            break;
        }
    }
}