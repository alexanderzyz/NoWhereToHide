/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE511_Logic_Time_Bomb__rand_16.java
Label Definition File: CWE511_Logic_Time_Bomb.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 511 Logic Time Bomb
* Sinks: rand
*    GoodSink: If specific random number generated, print to the console
*    BadSink : If specific random number generated, launch an executable
* Flow Variant: 16 Control flow: while(true)
*
* */

package testcases.CWE511_Logic_Time_Bomb;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE511_Logic_Time_Bomb__rand_16 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        while(true)
        {
            /* FLAW: PRNG triggered backdoor */
            if ((new SecureRandom()).nextInt() == 20000)
            {
                Runtime.getRuntime().exec("c:\\windows\\system32\\evil.exe");
            }
            break;
        }
    }
}