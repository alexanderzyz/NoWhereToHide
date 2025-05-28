/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE549_Missing_Password_Masking__Servlet_05.java
Label Definition File: CWE549_Missing_Password_Masking__Servlet.label.xml
Template File: point-flaw-05.tmpl.java
*/
/*
* @description
* CWE: 549 Passwords should be masked during entry to prevent others from stealing them
* Sinks:
*    GoodSink: password field masked
*    BadSink : password field unmasked
* Flow Variant: 05 Control flow: if(privateTrue) and if(privateFalse)
*
* */

package testcases.CWE549_Missing_Password_Masking;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE549_Missing_Password_Masking__Servlet_05 extends AbstractTestCaseServlet
{
    /* The two variables below are not defined as "final", but are never
     * assigned any other value, so a tool should be able to identify that
     * reads of these will always return their initialized values.
     */
    private boolean privateTrue = true;
    private boolean privateFalse = false;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (privateTrue)
        {
            response.getWriter().println("<form id=\"form\" name=\"form\" method=\"post\" action=\"password-test-servlet\">");
            response.getWriter().println("Username: <input name=\"username\" type=\"text\" tabindex=\"10\" /><br><br>");
            /* FLAW: password field should be masked (type="text") */
            response.getWriter().println("Password: <input name=\"password\" type=\"text\" tabindex=\"10\" />");
            response.getWriter().println("<input type=\"submit\" name=\"submit\" value=\"Login-bad\" /></form>");
        }
    }
}