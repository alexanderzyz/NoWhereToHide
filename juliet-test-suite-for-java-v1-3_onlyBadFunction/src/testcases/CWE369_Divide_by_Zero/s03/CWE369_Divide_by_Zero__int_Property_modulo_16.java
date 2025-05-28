/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__int_Property_modulo_16.java
Label Definition File: CWE369_Divide_by_Zero__int.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 369 Divide by zero
* BadSource: Property Read data from a system property
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: modulo
*    GoodSink: Check for zero before modulo
*    BadSink : Modulo by a value that may be zero
* Flow Variant: 16 Control flow: while(true)
*
* */

package testcases.CWE369_Divide_by_Zero.s03;
import testcasesupport.*;

import javax.servlet.http.*;

import java.util.logging.Level;

public class CWE369_Divide_by_Zero__int_Property_modulo_16 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int data;

        while (true)
        {
            data = Integer.MIN_VALUE; /* Initialize data */
            /* get system property user.home */
            /* POTENTIAL FLAW: Read data from a system property */
            {
                String stringNumber = System.getProperty("user.home");
                try
                {
                    data = Integer.parseInt(stringNumber.trim());
                }
                catch(NumberFormatException exceptNumberFormat)
                {
                    IO.logger.log(Level.WARNING, "Number format exception parsing data from string", exceptNumberFormat);
                }
            }
            break;
        }

        while (true)
        {
            /* POTENTIAL FLAW: Zero modulus will cause an issue.  An integer division will
            result in an exception.  */
            IO.writeLine("100%" + data + " = " + (100 % data) + "\n");
            break;
        }
    }
}