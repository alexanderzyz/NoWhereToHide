/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE398_Poor_Code_Quality__empty_else_09.java
Label Definition File: CWE398_Poor_Code_Quality.label.xml
Template File: point-flaw-09.tmpl.java
*/
/*
* @description
* CWE: 398 Indicator of Poor Code Quality
* Sinks: empty_else
*    GoodSink: Else statement contains code
*    BadSink : An empty else statement has no effect
* Flow Variant: 09 Control flow: if(IO.STATIC_FINAL_TRUE) and if(IO.STATIC_FINAL_FALSE)
*
* */

package testcases.CWE398_Poor_Code_Quality;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE398_Poor_Code_Quality__empty_else_09 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (IO.STATIC_FINAL_TRUE)
        {
            int x;
            x = (new SecureRandom()).nextInt();
            if (x == 0)
            {
                IO.writeLine("Inside the else statement");
            }
            /* FLAW: An empty else statement has no effect */
            else
            {
            }
            IO.writeLine("Hello from bad()");
        }
    }
}