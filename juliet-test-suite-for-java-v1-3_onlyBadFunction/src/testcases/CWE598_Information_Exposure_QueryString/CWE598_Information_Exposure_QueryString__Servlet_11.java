/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE598_Information_Exposure_QueryString__Servlet_11.java
Label Definition File: CWE598_Information_Exposure_QueryString__Servlet.label.xml
Template File: point-flaw-11.tmpl.java
*/
/*
* @description
* CWE: 598 Information Exposure Through Query Strings in GET Request
* Sinks:
*    GoodSink: post password field
*    BadSink : get password field
* Flow Variant: 11 Control flow: if(IO.staticReturnsTrue()) and if(IO.staticReturnsFalse())
*
* */

package testcases.CWE598_Information_Exposure_QueryString;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE598_Information_Exposure_QueryString__Servlet_11 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (IO.staticReturnsTrue())
        {
            response.getWriter().println("<form id=\"form\" name=\"form\" method=\"get\" action=\"password-test-servlet\">"); /* FLAW: method should be post instead of get */
            response.getWriter().println("Username: <input name=\"username\" type=\"text\" tabindex=\"10\" /><br><br>");
            response.getWriter().println("Password: <input name=\"password\" type=\"password\" tabindex=\"10\" />");
            response.getWriter().println("<input type=\"submit\" name=\"submit\" value=\"Login-bad\" /></form>");
        }
    }
}