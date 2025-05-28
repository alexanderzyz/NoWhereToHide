/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE328_Reversible_One_Way_Hash__MD2_01.java
Label Definition File: CWE328_Reversible_One_Way_Hash.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 328 Reversible One Way Hash
* Sinks: MD2
*    GoodSink: SHA512
*    BadSink : MD2
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE328_Reversible_One_Way_Hash;

import testcasesupport.*;

import java.security.MessageDigest;

public class CWE328_Reversible_One_Way_Hash__MD2_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        String input = "Test Input";

        /* FLAW: Insecure cryptographic hashing algorithm (MD2) */
        MessageDigest messageDigest = MessageDigest.getInstance("MD2");
        byte[] hashValue = messageDigest.digest(input.getBytes("UTF-8")); /* INCIDENTAL FLAW: Hard-coded input to hash algorithm */

        IO.writeLine(IO.toHex(hashValue));

    }
}