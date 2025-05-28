/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__passwordAuth_68a.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-68a.tmpl.java
*/
/*
 * @description
 * CWE: 259 Hard Coded Password
 * BadSource: hardcodedPassword Set data to a hardcoded string
 * GoodSource: Read data from the console using readLine()
 * BadSink: passwordAuth data used as password in PasswordAuthentication()
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE259_Hard_Coded_Password;

import testcasesupport.*;

import java.util.logging.Level;
import java.io.*;

public class CWE259_Hard_Coded_Password__passwordAuth_68a extends AbstractTestCase
{
    public static String data;

    public void bad() throws Throwable
    {

        /* FLAW: Set data to a hardcoded string */
        data = "7e5tc4s3";

        (new CWE259_Hard_Coded_Password__passwordAuth_68b()).badSink();
    }
}