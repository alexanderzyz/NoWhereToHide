/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE90_LDAP_Injection__getParameter_Servlet_54a.java
Label Definition File: CWE90_LDAP_Injection.label.xml
Template File: sources-sink-54a.tmpl.java
*/
/*
 * @description
 * CWE: 90 LDAP Injection
 * BadSource: getParameter_Servlet Read data from a querystring using getParameter()
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : data concatenated into LDAP search, which could result in LDAP Injection
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE90_LDAP_Injection;

import testcasesupport.*;

import javax.servlet.http.*;


public class CWE90_LDAP_Injection__getParameter_Servlet_54a extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Read data from a querystring using getParameter */
        data = request.getParameter("name");

        (new CWE90_LDAP_Injection__getParameter_Servlet_54b()).badSink(data , request, response);
    }
}