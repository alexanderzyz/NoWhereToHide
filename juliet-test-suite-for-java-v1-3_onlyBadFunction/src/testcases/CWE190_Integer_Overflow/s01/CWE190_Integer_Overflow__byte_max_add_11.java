/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__byte_max_add_11.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-11.tmpl.java
*/
/*
* @description
* CWE: 190 Integer Overflow
* BadSource: max Set data to the max value for byte
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: add
*    GoodSink: Ensure there will not be an overflow before adding 1 to data
*    BadSink : Add 1 to data, which can cause an overflow
* Flow Variant: 11 Control flow: if(IO.staticReturnsTrue()) and if(IO.staticReturnsFalse())
*
* */

package testcases.CWE190_Integer_Overflow.s01;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__byte_max_add_11 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        byte data;
        if (IO.staticReturnsTrue())
        {
            /* POTENTIAL FLAW: Use the maximum size of the data type */
            data = Byte.MAX_VALUE;
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0;
        }

        if(IO.staticReturnsTrue())
        {
            /* POTENTIAL FLAW: if data == Byte.MAX_VALUE, this will overflow */
            byte result = (byte)(data + 1);
            IO.writeLine("result: " + result);
        }
    }
}