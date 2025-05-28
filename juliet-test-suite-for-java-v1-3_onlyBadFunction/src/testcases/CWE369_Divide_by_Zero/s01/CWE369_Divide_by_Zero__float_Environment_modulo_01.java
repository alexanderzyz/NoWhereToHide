/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__float_Environment_modulo_01.java
Label Definition File: CWE369_Divide_by_Zero__float.label.xml
Template File: sources-sinks-01.tmpl.java
*/
/*
* @description
* CWE: 369 Divide by zero
* BadSource: Environment Read data from an environment variable
* GoodSource: A hardcoded non-zero number (two)
* Sinks: modulo
*    GoodSink: Check for zero before modulo
*    BadSink : Modulo by a value that may be zero
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE369_Divide_by_Zero.s01;
import testcasesupport.*;

import java.util.logging.Level;

public class CWE369_Divide_by_Zero__float_Environment_modulo_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        float data;

        data = -1.0f; /* Initialize data */

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read data from an environment variable */
        {
            String stringNumber = System.getenv("ADD");
            if (stringNumber != null)
            {
                try
                {
                    data = Float.parseFloat(stringNumber.trim());
                }
                catch (NumberFormatException exceptNumberFormat)
                {
                    IO.logger.log(Level.WARNING, "Number format exception parsing data from string", exceptNumberFormat);
                }
            }
        }

        /* POTENTIAL FLAW: Possibly modulo by zero */
        int result = (int)(100.0 % data);
        IO.writeLine(result);

    }
}