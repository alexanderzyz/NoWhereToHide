/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE80_XSS__Servlet_getQueryString_Servlet_07.java
Label Definition File: CWE80_XSS__Servlet.label.xml
Template File: sources-sink-07.tmpl.java
*/
/*
* @description
* CWE: 80 Cross Site Scripting (XSS)
* BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
* GoodSource: A hardcoded string
* BadSink:  Display of data in web page without any encoding or validation
* Flow Variant: 07 Control flow: if(privateFive==5) and if(privateFive!=5)
*
* */

package testcases.CWE80_XSS.s01;
import testcasesupport.*;

import javax.servlet.http.*;

import java.util.StringTokenizer;

public class CWE80_XSS__Servlet_getQueryString_Servlet_07 extends AbstractTestCaseServlet
{
    /* The variable below is not declared "final", but is never assigned
     * any other value so a tool should be able to identify that reads of
     * this will always give its initialized value.
     */
    private int privateFive = 5;

    /* uses badsource and badsink */
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (privateFive == 5)
        {
            data = ""; /* initialize data in case id is not in query string */
            /* POTENTIAL FLAW: Parse id param out of the URL querystring (without using getParameter()) */
            {
                StringTokenizer tokenizer = new StringTokenizer(request.getQueryString(), "&");
                while (tokenizer.hasMoreTokens())
                {
                    String token = tokenizer.nextToken(); /* a token will be like "id=foo" */
                    if(token.startsWith("id=")) /* check if we have the "id" parameter" */
                    {
                        data = token.substring(3); /* set data to "foo" */
                        break; /* exit while loop */
                    }
                }
            }
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = null;
        }

        if (data != null)
        {
            /* POTENTIAL FLAW: Display of data in web page without any encoding or validation */
            response.getWriter().println("<br>bad(): data = " + data);
        }

    }
}