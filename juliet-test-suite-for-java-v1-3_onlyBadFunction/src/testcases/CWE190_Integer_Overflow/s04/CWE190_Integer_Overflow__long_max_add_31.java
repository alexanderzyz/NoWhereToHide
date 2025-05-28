/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__long_max_add_31.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-31.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: max Set data to the max value for long
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: add
 *    GoodSink: Ensure there will not be an overflow before adding 1 to data
 *    BadSink : Add 1 to data, which can cause an overflow
 * Flow Variant: 31 Data flow: make a copy of data within the same method
 *
 * */

package testcases.CWE190_Integer_Overflow.s04;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__long_max_add_31 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        long dataCopy;
        {
            long data;

            /* POTENTIAL FLAW: Use the maximum size of the data type */
            data = Long.MAX_VALUE;

            dataCopy = data;
        }
        {
            long data = dataCopy;

            /* POTENTIAL FLAW: if data == Long.MAX_VALUE, this will overflow */
            long result = (long)(data + 1);

            IO.writeLine("result: " + result);

        }
    }
}