/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE617_Reachable_Assertion__false_01.java
Label Definition File: CWE617_Reachable_Assertion.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 617 Assertion is reachable
* Sinks: false
*    GoodSink: assert true, which will never trigger
*    BadSink : assert false, which will always trigger
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE617_Reachable_Assertion;

import testcasesupport.*;

public class CWE617_Reachable_Assertion__false_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        /* FLAW: this assertion can be reached, and will always trigger (if code is compiled using -ea option to enable assert) */
        assert false; /* INCIDENTAL: CWE 571 - expression is always true - it's "true" because assert(e) basically does if (!(e)) */

    }
}