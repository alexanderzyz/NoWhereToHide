/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE90_LDAP_Injection__Property_67a.java
Label Definition File: CWE90_LDAP_Injection.label.xml
Template File: sources-sink-67a.tmpl.java
*/
/*
 * @description
 * CWE: 90 LDAP Injection
 * BadSource: Property Read data from a system property
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : data concatenated into LDAP search, which could result in LDAP Injection
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE90_LDAP_Injection;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE90_LDAP_Injection__Property_67a extends AbstractTestCase
{
    static class Container
    {
        public String containerOne;
    }

    public void bad() throws Throwable
    {
        String data;

        /* get system property user.home */
        /* POTENTIAL FLAW: Read data from a system property */
        data = System.getProperty("user.home");

        Container dataContainer = new Container();
        dataContainer.containerOne = data;
        (new CWE90_LDAP_Injection__Property_67b()).badSink(dataContainer  );
    }
}