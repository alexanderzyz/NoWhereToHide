/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE478_Missing_Default_Case_in_Switch__basic_01.java
Label Definition File: CWE478_Missing_Default_Case_in_Switch__basic.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 478 Missing Default Case in Switch
* Sinks:
*    GoodSink: Use default case in switch statement
*    BadSink : No default case in a switch statement
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE478_Missing_Default_Case_in_Switch;

import testcasesupport.*;

import java.io.*;

import java.security.SecureRandom;

public class CWE478_Missing_Default_Case_in_Switch__basic_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        String stringIntValue = "";
        int x = (new SecureRandom()).nextInt(3);

        switch (x)
        {
        case 0:
            stringIntValue = "0";
            break;
        case 1:
            stringIntValue = "1";
            break;
            /* FLAW: x could be 2, and there is no 'default' case for that */
        }

        IO.writeLine(stringIntValue);

    }
}