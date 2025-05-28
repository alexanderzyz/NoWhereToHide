/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE643_Xpath_Injection__Property_81a.java
Label Definition File: CWE643_Xpath_Injection.label.xml
Template File: sources-sinks-81a.tmpl.java
*/
/*
 * @description
 * CWE: 643 Xpath Injection
 * BadSource: Property Read data from a system property
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: validate input through StringEscapeUtils
 *    BadSink : user input is used without validate
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE643_Xpath_Injection;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE643_Xpath_Injection__Property_81a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String data;

        /* get system property user.home */
        /* POTENTIAL FLAW: Read data from a system property */
        data = System.getProperty("user.home");

        CWE643_Xpath_Injection__Property_81_base baseObject = new CWE643_Xpath_Injection__Property_81_bad();
        baseObject.action(data );
    }
}