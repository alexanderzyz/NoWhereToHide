/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__getQueryString_Servlet_for_loop_68a.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-68a.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: for_loop
 *    GoodSink: Validate count before using it as the loop variant in a for loop
 *    BadSink : Use count as the loop variant in a for loop
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s01;
import testcasesupport.*;

import javax.servlet.http.*;


import java.util.StringTokenizer;
import java.util.logging.Level;

public class CWE400_Resource_Exhaustion__getQueryString_Servlet_for_loop_68a extends AbstractTestCaseServlet
{
    public static int count;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        count = Integer.MIN_VALUE; /* initialize count in case id is not in query string */

        /* POTENTIAL FLAW: Parse id param out of the URL querystring (without using getParam) */
        {
            StringTokenizer tokenizer = new StringTokenizer(request.getQueryString(), "&");

            while (tokenizer.hasMoreTokens())
            {
                String token = tokenizer.nextToken(); /* a token will be like "id=33" */
                if(token.startsWith("id=")) /* check if we have the "id" parameter" */
                {
                    try
                    {
                        count = Integer.parseInt(token.substring(3)); /* set count to the int 33 */
                    }
                    catch(NumberFormatException exceptNumberFormat)
                    {
                        IO.logger.log(Level.WARNING, "Number format exception reading id from query string", exceptNumberFormat);
                    }
                    break; /* exit while loop */
                }
            }
        }

        (new CWE400_Resource_Exhaustion__getQueryString_Servlet_for_loop_68b()).badSink(request, response);
    }
}