/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__float_random_modulo_66a.java
Label Definition File: CWE369_Divide_by_Zero__float.label.xml
Template File: sources-sinks-66a.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: random Set data to a random value between 0.0f (inclusive) and 1.0f (exclusive)
 * GoodSource: A hardcoded non-zero number (two)
 * Sinks: modulo
 *    GoodSink: Check for zero before modulo
 *    BadSink : Modulo by a value that may be zero
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE369_Divide_by_Zero.s02;
import testcasesupport.*;

import java.security.SecureRandom;

public class CWE369_Divide_by_Zero__float_random_modulo_66a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        float data;

        /* POTENTIAL FLAW: Set data to a random value between 0.0f (inclusive) and 1.0f (exclusive) */
        SecureRandom secureRandom = new SecureRandom();
        data = secureRandom.nextFloat();

        float[] dataArray = new float[5];
        dataArray[2] = data;
        (new CWE369_Divide_by_Zero__float_random_modulo_66b()).badSink(dataArray  );
    }
}