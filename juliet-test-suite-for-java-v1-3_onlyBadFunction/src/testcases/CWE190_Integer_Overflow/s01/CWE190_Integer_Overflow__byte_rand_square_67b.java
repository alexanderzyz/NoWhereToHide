/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__byte_rand_square_67b.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: rand Set data to result of rand()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: square
 *    GoodSink: Ensure there will not be an overflow before squaring data
 *    BadSink : Square data, which can lead to overflow
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow.s01;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__byte_rand_square_67b
{
    public void badSink(CWE190_Integer_Overflow__byte_rand_square_67a.Container dataContainer ) throws Throwable
    {
        byte data = dataContainer.containerOne;

        /* POTENTIAL FLAW: if (data*data) > Byte.MAX_VALUE, this will overflow */
        byte result = (byte)(data * data);

        IO.writeLine("result: " + result);

    }
}