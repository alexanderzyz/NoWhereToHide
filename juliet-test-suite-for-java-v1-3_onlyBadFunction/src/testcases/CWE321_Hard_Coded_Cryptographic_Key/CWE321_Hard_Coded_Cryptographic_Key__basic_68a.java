/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE321_Hard_Coded_Cryptographic_Key__basic_68a.java
Label Definition File: CWE321_Hard_Coded_Cryptographic_Key__basic.label.xml
Template File: sources-sink-68a.tmpl.java
*/
/*
 * @description
 * CWE: 321 Hard coded crypto key
 * BadSource:  Set data to a hardcoded value
 * GoodSource: Read data from the console using readLine()
 * BadSink:  Use data as a cryptographic key
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE321_Hard_Coded_Cryptographic_Key;

import testcasesupport.*;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.logging.Level;

public class CWE321_Hard_Coded_Cryptographic_Key__basic_68a extends AbstractTestCase
{
    public static String data;

    public void bad() throws Throwable
    {

        /* FLAW: Set data to a hardcoded value */
        data = "23 ~j;asn!@#/>as";

        (new CWE321_Hard_Coded_Cryptographic_Key__basic_68b()).badSink();
    }
}