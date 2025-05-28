/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__float_random_divide_22a.java
Label Definition File: CWE369_Divide_by_Zero__float.label.xml
Template File: sources-sinks-22a.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: random Set data to a random value between 0.0f (inclusive) and 1.0f (exclusive)
 * GoodSource: A hardcoded non-zero number (two)
 * Sinks: divide
 *    GoodSink: Check for zero before dividing
 *    BadSink : Dividing by a value that may be zero
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE369_Divide_by_Zero.s02;
import testcasesupport.*;

import java.security.SecureRandom;

public class CWE369_Divide_by_Zero__float_random_divide_22a extends AbstractTestCase
{
    /* The public static variable below is used to drive control flow in the sink function.
     * The public static variable mimics a global variable in the C/C++ language family. */
    public static boolean badPublicStatic = false;

    public void bad() throws Throwable
    {
        float data = 0.0f;

        /* POTENTIAL FLAW: Set data to a random value between 0.0f (inclusive) and 1.0f (exclusive) */
        SecureRandom secureRandom = new SecureRandom();
        data = secureRandom.nextFloat();

        badPublicStatic = true;
        (new CWE369_Divide_by_Zero__float_random_divide_22b()).badSink(data );
    }
}