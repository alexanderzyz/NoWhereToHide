/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE533_Info_Exposure_Server_Log__Servlet_14.java
Label Definition File: CWE533_Info_Exposure_Server_Log__Servlet.label.xml
Template File: point-flaw-14.tmpl.java
*/
/*
* @description
* CWE: 533 Information Exposure through Server Log Files
* Sinks:
*    GoodSink: log non-sensitive information to the server log
*    BadSink : Expose the session ID to the server log
* Flow Variant: 14 Control flow: if(IO.staticFive==5) and if(IO.staticFive!=5)
*
* */

package testcases.CWE533_Info_Exposure_Server_Log;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE533_Info_Exposure_Server_Log__Servlet_14 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (IO.staticFive == 5)
        {
            if (request.getParameter("username") == null)
            {
                return;
            }
            String username = request.getParameter("username");
            if (username.matches("[a-zA-Z0-9]*"))
            {
                HttpSession session = request.getSession(true);
                /* FLAW: Expose the session ID to server log */
                log("Username: " + username + " Session ID:" + session.getId());
            }
            else
            {
                response.getWriter().println("Invalid characters");
            }
        }
    }
}