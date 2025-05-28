/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE328_Reversible_One_Way_Hash__SHA1_10.java
Label Definition File: CWE328_Reversible_One_Way_Hash.label.xml
Template File: point-flaw-10.tmpl.java
*/
/*
* @description
* CWE: 328 Reversible One Way Hash
* Sinks: SHA1
*    GoodSink: SHA512
*    BadSink : SHA1
* Flow Variant: 10 Control flow: if(IO.staticTrue) and if(IO.staticFalse)
*
* */

package testcases.CWE328_Reversible_One_Way_Hash;

import testcasesupport.*;

import java.security.MessageDigest;

public class CWE328_Reversible_One_Way_Hash__SHA1_10 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (IO.staticTrue)
        {
            String input = "Test Input";
            /* FLAW: Insecure cryptographic hashing algorithm (SHA1) */
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            byte[] hashValue = messageDigest.digest(input.getBytes("UTF-8")); /* INCIDENTAL FLAW: Hard-coded input to hash algorithm */
            IO.writeLine(IO.toHex(hashValue));
        }
    }
}