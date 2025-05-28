/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE338_Weak_PRNG__math_01.java
Label Definition File: CWE338_Weak_PRNG.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 338 Use of Cryptographically Weak PRNG
* Sinks: math
*    GoodSink: stronger PRNG
*    BadSink : weak PRNG
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE338_Weak_PRNG;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE338_Weak_PRNG__math_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        /* FLAW: Math.random() is a known weak PRNG */
        IO.writeLine("" + Math.random());

    }
}