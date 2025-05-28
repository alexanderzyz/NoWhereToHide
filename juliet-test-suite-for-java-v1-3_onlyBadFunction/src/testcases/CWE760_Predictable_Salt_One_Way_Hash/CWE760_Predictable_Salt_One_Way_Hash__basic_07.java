/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE760_Predictable_Salt_One_Way_Hash__basic_07.java
Label Definition File: CWE760_Predictable_Salt_One_Way_Hash__basic.label.xml
Template File: point-flaw-07.tmpl.java
*/
/*
* @description
* CWE: 760 Use of one-way hash with a predictable salt
* Sinks:
*    GoodSink: SHA512 with a sufficiently random salt
*    BadSink : SHA512 with a predictable salt
* Flow Variant: 07 Control flow: if(privateFive==5) and if(privateFive!=5)
*
* */

package testcases.CWE760_Predictable_Salt_One_Way_Hash;

import testcasesupport.*;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Random;

public class CWE760_Predictable_Salt_One_Way_Hash__basic_07 extends AbstractTestCase
{
    /* The variable below is not declared "final", but is never assigned
     * any other value so a tool should be able to identify that reads of
     * this will always give its initialized value.
     */
    private int privateFive = 5;

    public void bad() throws Throwable
    {
        if (privateFive == 5)
        {
            Random random = new Random();
            MessageDigest hash = MessageDigest.getInstance("SHA-512");
            /* FLAW: SHA512 with a predictable salt */
            hash.update((Integer.toString(random.nextInt())).getBytes("UTF-8"));
            byte[] hashValue = hash.digest("hash me".getBytes("UTF-8"));
            IO.writeLine(IO.toHex(hashValue));
        }
    }
}