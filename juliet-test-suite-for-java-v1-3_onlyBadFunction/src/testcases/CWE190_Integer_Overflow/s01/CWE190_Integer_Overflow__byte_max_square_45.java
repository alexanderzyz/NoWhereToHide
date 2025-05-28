/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__byte_max_square_45.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-45.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: max Set data to the max value for byte
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: square
 *    GoodSink: Ensure there will not be an overflow before squaring data
 *    BadSink : Square data, which can lead to overflow
 * Flow Variant: 45 Data flow: data passed as a private class member variable from one function to another in the same class
 *
 * */

package testcases.CWE190_Integer_Overflow.s01;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__byte_max_square_45 extends AbstractTestCase
{
    private byte dataBad;
    private byte dataGoodG2B;
    private byte dataGoodB2G;

    private void badSink() throws Throwable
    {
        byte data = dataBad;

        /* POTENTIAL FLAW: if (data*data) > Byte.MAX_VALUE, this will overflow */
        byte result = (byte)(data * data);

        IO.writeLine("result: " + result);

    }

    public void bad() throws Throwable
    {
        byte data;

        /* POTENTIAL FLAW: Use the maximum size of the data type */
        data = Byte.MAX_VALUE;

        dataBad = data;
        badSink();
    }
}