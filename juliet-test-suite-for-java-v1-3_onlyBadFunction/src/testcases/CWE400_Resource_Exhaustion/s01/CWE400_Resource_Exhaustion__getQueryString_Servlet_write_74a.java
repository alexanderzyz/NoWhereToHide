/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__getQueryString_Servlet_write_74a.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-74a.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: write
 *    GoodSink: Write to a file count number of times, but first validate count
 *    BadSink : Write to a file count number of times
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s01;
import testcasesupport.*;
import java.util.HashMap;

import javax.servlet.http.*;


import java.util.StringTokenizer;
import java.util.logging.Level;

public class CWE400_Resource_Exhaustion__getQueryString_Servlet_write_74a extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int count;

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

        HashMap<Integer,Integer> countHashMap = new HashMap<Integer,Integer>();
        countHashMap.put(0, count);
        countHashMap.put(1, count);
        countHashMap.put(2, count);
        (new CWE400_Resource_Exhaustion__getQueryString_Servlet_write_74b()).badSink(countHashMap , request, response );
    }
}