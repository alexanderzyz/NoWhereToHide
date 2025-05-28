/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE511_Logic_Time_Bomb__rand_02.java
Label Definition File: CWE511_Logic_Time_Bomb.label.xml
Template File: point-flaw-02.tmpl.java
*/
/*
* @description
* CWE: 511 Logic Time Bomb
* Sinks: rand
*    GoodSink: If specific random number generated, print to the console
*    BadSink : If specific random number generated, launch an executable
* Flow Variant: 02 Control flow: if(true) and if(false)
*
* */

package testcases.CWE511_Logic_Time_Bomb;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE511_Logic_Time_Bomb__rand_02 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (true)
        {
            /* FLAW: PRNG triggered backdoor */
            if ((new SecureRandom()).nextInt() == 20000)
            {
                Runtime.getRuntime().exec("c:\\windows\\system32\\evil.exe");
            }
        }
    }
}