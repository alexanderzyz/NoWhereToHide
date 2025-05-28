/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__getParameter_Servlet_for_loop_16.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 400 Resource Exhaustion
* BadSource: getParameter_Servlet Read count from a querystring using getParameter()
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: for_loop
*    GoodSink: Validate count before using it as the loop variant in a for loop
*    BadSink : Use count as the loop variant in a for loop
* Flow Variant: 16 Control flow: while(true)
*
* */

package testcases.CWE400_Resource_Exhaustion.s01;
import testcasesupport.*;

import javax.servlet.http.*;


import java.util.logging.Level;

public class CWE400_Resource_Exhaustion__getParameter_Servlet_for_loop_16 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int count;

        while (true)
        {
            count = Integer.MIN_VALUE; /* Initialize count */
            /* POTENTIAL FLAW: Read count from a querystring using getParameter() */
            {
                String stringNumber = request.getParameter("name");
                try
                {
                    count = Integer.parseInt(stringNumber.trim());
                }
                catch(NumberFormatException exceptNumberFormat)
                {
                    IO.logger.log(Level.WARNING, "Number format exception reading count from parameter 'name'", exceptNumberFormat);
                }
            }
            break;
        }

        while (true)
        {
            int i = 0;
            /* POTENTIAL FLAW: For loop using count as the loop variant and no validation */
            for (i = 0; i < count; i++)
            {
                IO.writeLine("Hello");
            }
            break;
        }
    }
}