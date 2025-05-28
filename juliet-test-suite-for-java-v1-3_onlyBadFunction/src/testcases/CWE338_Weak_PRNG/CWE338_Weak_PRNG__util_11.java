/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE338_Weak_PRNG__util_11.java
Label Definition File: CWE338_Weak_PRNG.label.xml
Template File: point-flaw-11.tmpl.java
*/
/*
* @description
* CWE: 338 Use of Cryptographically Weak PRNG
* Sinks: util
*    GoodSink: stronger PRNG
*    BadSink : weak PRNG
* Flow Variant: 11 Control flow: if(IO.staticReturnsTrue()) and if(IO.staticReturnsFalse())
*
* */

package testcases.CWE338_Weak_PRNG;

import testcasesupport.*;

import java.security.SecureRandom;

import java.util.Random;

public class CWE338_Weak_PRNG__util_11 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (IO.staticReturnsTrue())
        {
            /* FLAW: java.util.Random() is considered a weak PRNG */
            Random random = new Random();
            IO.writeLine("" + random.nextInt());
        }
    }
}