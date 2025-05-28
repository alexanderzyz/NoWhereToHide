/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE615_Info_Exposure_by_Comment__Servlet_01.java
Label Definition File: CWE615_Info_Exposure_by_Comment__Servlet.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 615 Information Exposure by Comment
* Sinks:
*    GoodSink: no disclosure of username and password
*    BadSink : disclose username and password
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE615_Info_Exposure_by_Comment;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE615_Info_Exposure_by_Comment__Servlet_01 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* FLAW: sensitive information exposed in client-side code comments */
        response.getWriter().println("<!--DB username = joe, DB password = 123-->" +
        "<form action=\"/test\" method=post>" +
        "<input type=text name=dbusername>" +
        "<input type=test name=dbpassword>" +
        "<input type=submit value=Submit>" +
        "</form>");

    }
}