/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE483_Incorrect_Block_Delimitation__semicolon_01.java
Label Definition File: CWE483_Incorrect_Block_Delimitation.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 483 Incorrect Block Delimitation
* Sinks: semicolon
*    GoodSink: Absence of suspicious semicolon
*    BadSink : Suspicious semicolon before the if statement brace
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE483_Incorrect_Block_Delimitation;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE483_Incorrect_Block_Delimitation__semicolon_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        int x, y;

        x = (new SecureRandom()).nextInt(3);
        y = 0;

        /* FLAW: Suspicious semicolon before the if statement brace */
        if (x == 0);
        {
            IO.writeLine("x == 0");
            y = 1; /* do something other than just printing in block */
        }

        IO.writeLine(y);

    }
}