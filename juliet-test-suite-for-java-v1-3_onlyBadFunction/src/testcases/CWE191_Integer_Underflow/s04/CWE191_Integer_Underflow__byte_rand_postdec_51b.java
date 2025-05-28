/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__byte_rand_postdec_51b.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-51b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: rand Set data to result of rand()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: decrement
 *    GoodSink: Ensure there will not be an underflow before decrementing data
 *    BadSink : Decrement data, which can cause an Underflow
 * Flow Variant: 51 Data flow: data passed as an argument from one function to another in different classes in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow.s04;
import testcasesupport.*;

public class CWE191_Integer_Underflow__byte_rand_postdec_51b
{
    public void badSink(byte data ) throws Throwable
    {

        /* POTENTIAL FLAW: if data == Byte.MIN_VALUE, this will overflow */
        data--;
        byte result = (byte)(data);

        IO.writeLine("result: " + result);

    }
}