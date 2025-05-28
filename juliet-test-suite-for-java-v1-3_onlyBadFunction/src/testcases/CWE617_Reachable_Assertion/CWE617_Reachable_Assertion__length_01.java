/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE617_Reachable_Assertion__length_01.java
Label Definition File: CWE617_Reachable_Assertion.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 617 Assertion is reachable
* Sinks: length
*    GoodSink: assert true, which will never trigger
*    BadSink : assert false, which will always trigger
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE617_Reachable_Assertion;

import testcasesupport.*;

public class CWE617_Reachable_Assertion__length_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        /* FLAW: assertion is false */
        assert "".length() > 0;

    }
}