/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE601_Open_Redirect__Servlet_getParameter_Servlet_53a.java
Label Definition File: CWE601_Open_Redirect__Servlet.label.xml
Template File: sources-sink-53a.tmpl.java
*/
/*
 * @description
 * CWE: 601 Open Redirect
 * BadSource: getParameter_Servlet Read data from a querystring using getParameter()
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : place redirect string directly into redirect api call
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE601_Open_Redirect;

import testcasesupport.*;

import javax.servlet.http.*;


public class CWE601_Open_Redirect__Servlet_getParameter_Servlet_53a extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Read data from a querystring using getParameter */
        data = request.getParameter("name");

        (new CWE601_Open_Redirect__Servlet_getParameter_Servlet_53b()).badSink(data , request, response);
    }
}