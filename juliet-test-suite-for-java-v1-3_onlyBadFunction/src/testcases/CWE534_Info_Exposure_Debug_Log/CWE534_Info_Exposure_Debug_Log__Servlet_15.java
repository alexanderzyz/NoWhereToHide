/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE534_Info_Exposure_Debug_Log__Servlet_15.java
Label Definition File: CWE534_Info_Exposure_Debug_Log__Servlet.label.xml
Template File: point-flaw-15.tmpl.java
*/
/*
* @description
* CWE: 534 Information Exposure through Debug Log Files
* Sinks:
*    GoodSink: log non-sensitive information to the debug log
*    BadSink : Expose the session ID to the debug log
* Flow Variant: 15 Control flow: switch(7)
*
* */

package testcases.CWE534_Info_Exposure_Debug_Log;

import testcasesupport.*;

import javax.servlet.http.*;
import java.util.logging.*;

public class CWE534_Info_Exposure_Debug_Log__Servlet_15 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        switch (7)
        {
        case 7:
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
            break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
            break;
        }
    }
}