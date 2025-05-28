/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__byte_console_readLine_predec_68b.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-68b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: decrement
 *    GoodSink: Ensure there will not be an underflow before decrementing data
 *    BadSink : Decrement data, which can cause an Underflow
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow.s05;
import testcasesupport.*;

public class CWE191_Integer_Underflow__byte_console_readLine_predec_68b
{
    public void badSink() throws Throwable
    {
        byte data = CWE191_Integer_Underflow__byte_console_readLine_predec_68a.data;

        /* POTENTIAL FLAW: if data == Byte.MIN_VALUE, this will overflow */
        byte result = (byte)(--data);

        IO.writeLine("result: " + result);

    }
}