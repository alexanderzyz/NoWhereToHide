/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE338_Weak_PRNG__util_02.java
Label Definition File: CWE338_Weak_PRNG.label.xml
Template File: point-flaw-02.tmpl.java
*/
/*
* @description
* CWE: 338 Use of Cryptographically Weak PRNG
* Sinks: util
*    GoodSink: stronger PRNG
*    BadSink : weak PRNG
* Flow Variant: 02 Control flow: if(true) and if(false)
*
* */

package testcases.CWE338_Weak_PRNG;

import testcasesupport.*;

import java.security.SecureRandom;

import java.util.Random;

public class CWE338_Weak_PRNG__util_02 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (true)
        {
            /* FLAW: java.util.Random() is considered a weak PRNG */
            Random random = new Random();
            IO.writeLine("" + random.nextInt());
        }
    }
}