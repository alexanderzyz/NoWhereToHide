/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE325_Missing_Required_Cryptographic_Step__MessageDigest_update_01.java
Label Definition File: CWE325_Missing_Required_Cryptographic_Step.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 325 Missing Required Cryptographic Step
* Sinks: MessageDigest_update
*    GoodSink: Include call to MessageDigest.update()
*    BadSink : Missing call to MessageDigest.update()
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE325_Missing_Required_Cryptographic_Step;

import testcasesupport.*;

import java.security.MessageDigest;

public class CWE325_Missing_Required_Cryptographic_Step__MessageDigest_update_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");

        /* FLAW: Missing call to MessageDigest.update().  This will result in the hash being of no data */

        IO.writeLine(IO.toHex(messageDigest.digest()));

    }
}