/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE328_Reversible_One_Way_Hash__MD2_17.java
Label Definition File: CWE328_Reversible_One_Way_Hash.label.xml
Template File: point-flaw-17.tmpl.java
*/
/*
* @description
* CWE: 328 Reversible One Way Hash
* Sinks: MD2
*    GoodSink: SHA512
*    BadSink : MD2
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE328_Reversible_One_Way_Hash;

import testcasesupport.*;

import java.security.MessageDigest;

public class CWE328_Reversible_One_Way_Hash__MD2_17 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        for(int j = 0; j < 1; j++)
        {
            String input = "Test Input";
            /* FLAW: Insecure cryptographic hashing algorithm (MD2) */
            MessageDigest messageDigest = MessageDigest.getInstance("MD2");
            byte[] hashValue = messageDigest.digest(input.getBytes("UTF-8")); /* INCIDENTAL FLAW: Hard-coded input to hash algorithm */
            IO.writeLine(IO.toHex(hashValue));
        }
    }
}