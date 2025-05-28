/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE398_Poor_Code_Quality__empty_else_01.java
Label Definition File: CWE398_Poor_Code_Quality.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 398 Indicator of Poor Code Quality
* Sinks: empty_else
*    GoodSink: Else statement contains code
*    BadSink : An empty else statement has no effect
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE398_Poor_Code_Quality;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE398_Poor_Code_Quality__empty_else_01 extends AbstractTestCase
{
    public void bad() throws Throwable
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