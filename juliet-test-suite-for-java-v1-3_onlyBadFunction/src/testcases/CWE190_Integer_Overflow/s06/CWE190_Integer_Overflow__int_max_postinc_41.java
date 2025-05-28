/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__int_max_postinc_41.java
Label Definition File: CWE190_Integer_Overflow__int.label.xml
Template File: sources-sinks-41.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: max Set data to the maximum value for int
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: increment
 *    GoodSink: Ensure there will not be an overflow before incrementing data
 *    BadSink : Increment data, which can cause an overflow
 * Flow Variant: 41 Data flow: data passed as an argument from one method to another in the same class
 *
 * */

package testcases.CWE190_Integer_Overflow.s06;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__int_max_postinc_41 extends AbstractTestCase
{
    private void badSink(int data ) throws Throwable
    {

        /* POTENTIAL FLAW: if data == Integer.MAX_VALUE, this will overflow */
        data++;
        int result = (int)(data);

        IO.writeLine("result: " + result);

    }

    public void bad() throws Throwable
    {
        int data;

        /* POTENTIAL FLAW: Use the maximum value for this type */
        data = Integer.MAX_VALUE;

        badSink(data  );
    }
}