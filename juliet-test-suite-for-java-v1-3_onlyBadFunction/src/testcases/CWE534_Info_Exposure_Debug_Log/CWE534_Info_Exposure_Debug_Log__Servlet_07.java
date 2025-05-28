/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE534_Info_Exposure_Debug_Log__Servlet_07.java
Label Definition File: CWE534_Info_Exposure_Debug_Log__Servlet.label.xml
Template File: point-flaw-07.tmpl.java
*/
/*
* @description
* CWE: 534 Information Exposure through Debug Log Files
* Sinks:
*    GoodSink: log non-sensitive information to the debug log
*    BadSink : Expose the session ID to the debug log
* Flow Variant: 07 Control flow: if(privateFive==5) and if(privateFive!=5)
*
* */

package testcases.CWE534_Info_Exposure_Debug_Log;

import testcasesupport.*;

import javax.servlet.http.*;
import java.util.logging.*;

public class CWE534_Info_Exposure_Debug_Log__Servlet_07 extends AbstractTestCaseServlet
{
    /* The variable below is not declared "final", but is never assigned
     * any other value so a tool should be able to identify that reads of
     * this will always give its initialized value.
     */
    private int privateFive = 5;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (privateFive == 5)
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
}