/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__int_min_postdec_68a.java
Label Definition File: CWE191_Integer_Underflow__int.label.xml
Template File: sources-sinks-68a.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: min Set data to the minimum value for int
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: decrement
 *    GoodSink: Ensure there will not be an underflow before decrementing data
 *    BadSink : Decrement data, which can cause an Underflow
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow.s04;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE191_Integer_Underflow__int_min_postdec_68a extends AbstractTestCase
{
    public static int data;

    public void bad() throws Throwable
    {

        /* POTENTIAL FLAW: Use the maximum value for this type */
        data = Integer.MIN_VALUE;

        (new CWE191_Integer_Underflow__int_min_postdec_68b()).badSink();
    }
}