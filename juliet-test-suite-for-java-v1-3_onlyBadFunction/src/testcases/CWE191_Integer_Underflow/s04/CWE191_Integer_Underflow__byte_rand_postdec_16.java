/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__byte_rand_postdec_16.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 191 Integer Underflow
* BadSource: rand Set data to result of rand()
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: decrement
*    GoodSink: Ensure there will not be an underflow before decrementing data
*    BadSink : Decrement data, which can cause an Underflow
* Flow Variant: 16 Control flow: while(true)
*
* */

package testcases.CWE191_Integer_Underflow.s04;
import testcasesupport.*;

public class CWE191_Integer_Underflow__byte_rand_postdec_16 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        byte data;

        while (true)
        {
            /* POTENTIAL FLAW: Use a random value */
            data = (byte)((new java.security.SecureRandom()).nextInt(1+Byte.MAX_VALUE-Byte.MIN_VALUE) + Byte.MIN_VALUE);
            break;
        }

        while (true)
        {
            /* POTENTIAL FLAW: if data == Byte.MIN_VALUE, this will overflow */
            data--;
            byte result = (byte)(data);
            IO.writeLine("result: " + result);
            break;
        }
    }
}