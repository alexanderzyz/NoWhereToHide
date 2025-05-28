/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE534_Info_Exposure_Debug_Log__Servlet_01.java
Label Definition File: CWE534_Info_Exposure_Debug_Log__Servlet.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 534 Information Exposure through Debug Log Files
* Sinks:
*    GoodSink: log non-sensitive information to the debug log
*    BadSink : Expose the session ID to the debug log
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE534_Info_Exposure_Debug_Log;

import testcasesupport.*;

import javax.servlet.http.*;
import java.util.logging.*;

public class CWE534_Info_Exposure_Debug_Log__Servlet_01 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        Logger logger = Logger.getLogger("cwe_testcases_logger");
        if (request.getParameter("username") == null)
        {
            return;
        }

        String username = request.getParameter("username");

        if (username.matches("[a-zA-Z0-9]*"))
        {
            HttpSession session = request.getSession(true);
            /* FLAW: Expose the session ID to debug log */
            logger.log(Level.FINEST, "Username: " + username + " Session ID:" + session.getId());
        }
        else
        {
            response.getWriter().println("Invalid characters");
        }

    }
}