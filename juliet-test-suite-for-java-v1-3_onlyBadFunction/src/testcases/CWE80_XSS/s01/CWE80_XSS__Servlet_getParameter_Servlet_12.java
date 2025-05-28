/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE80_XSS__Servlet_getParameter_Servlet_12.java
Label Definition File: CWE80_XSS__Servlet.label.xml
Template File: sources-sink-12.tmpl.java
*/
/*
* @description
* CWE: 80 Cross Site Scripting (XSS)
* BadSource: getParameter_Servlet Read data from a querystring using getParameter()
* GoodSource: A hardcoded string
* BadSink:  Display of data in web page without any encoding or validation
* Flow Variant: 12 Control flow: if(IO.staticReturnsTrueOrFalse())
*
* */

package testcases.CWE80_XSS.s01;
import testcasesupport.*;

import javax.servlet.http.*;


public class CWE80_XSS__Servlet_getParameter_Servlet_12 extends AbstractTestCaseServlet
{
    /* uses badsource and badsink - see how tools report flaws that don't always occur */
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (IO.staticReturnsTrueOrFalse())
        {
            /* POTENTIAL FLAW: Read data from a querystring using getParameter */
            data = request.getParameter("name");
        }
        else
        {

            /* FIX: Use a hardcoded string */
            data = "foo";

        }

        if (data != null)
        {
            /* POTENTIAL FLAW: Display of data in web page without any encoding or validation */
            response.getWriter().println("<br>bad(): data = " + data);
        }

    }
}