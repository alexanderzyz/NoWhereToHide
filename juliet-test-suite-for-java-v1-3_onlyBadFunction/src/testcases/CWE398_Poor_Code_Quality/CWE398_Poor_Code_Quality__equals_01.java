/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE398_Poor_Code_Quality__equals_01.java
Label Definition File: CWE398_Poor_Code_Quality.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 398 Indicator of Poor Code Quality
* Sinks: equals
*    GoodSink: Set a variable equal to another variable
*    BadSink : Setting a variable equal to itself has no effect
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE398_Poor_Code_Quality;

import testcasesupport.*;

public class CWE398_Poor_Code_Quality__equals_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        int intOne = 1;

        IO.writeLine(intOne);

        /* FLAW: The statement below has no effect since it is setting a variable to itself */
        intOne = intOne;

        IO.writeLine(intOne);

    }
}