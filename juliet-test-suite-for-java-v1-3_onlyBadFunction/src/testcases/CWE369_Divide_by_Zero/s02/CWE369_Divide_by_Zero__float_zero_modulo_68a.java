/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__float_zero_modulo_68a.java
Label Definition File: CWE369_Divide_by_Zero__float.label.xml
Template File: sources-sinks-68a.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: zero Set data to a hardcoded value of zero
 * GoodSource: A hardcoded non-zero number (two)
 * Sinks: modulo
 *    GoodSink: Check for zero before modulo
 *    BadSink : Modulo by a value that may be zero
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE369_Divide_by_Zero.s02;
import testcasesupport.*;

public class CWE369_Divide_by_Zero__float_zero_modulo_68a extends AbstractTestCase
{
    public static float data;

    public void bad() throws Throwable
    {

        data = 0.0f; /* POTENTIAL FLAW: data is set to zero */

        (new CWE369_Divide_by_Zero__float_zero_modulo_68b()).badSink();
    }
}