/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__int_getParameter_Servlet_postdec_10.java
Label Definition File: CWE191_Integer_Underflow__int.label.xml
Template File: sources-sinks-10.tmpl.java
*/
/*
* @description
* CWE: 191 Integer Underflow
* BadSource: getParameter_Servlet Read data from a querystring using getParameter()
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: decrement
*    GoodSink: Ensure there will not be an underflow before decrementing data
*    BadSink : Decrement data, which can cause an Underflow
* Flow Variant: 10 Control flow: if(IO.staticTrue) and if(IO.staticFalse)
*
* */

package testcases.CWE191_Integer_Underflow.s04;
import testcasesupport.*;

import javax.servlet.http.*;


import java.util.logging.Level;

public class CWE191_Integer_Underflow__int_getParameter_Servlet_postdec_10 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;
        if (IO.staticTrue)
        {
            data = Integer.MIN_VALUE; /* Initialize data */
            /* POTENTIAL FLAW: Read data from a querystring using getParameter() */
            {
                String stringNumber = request.getParameter("name");
                try
                {
                    data = Integer.parseInt(stringNumber.trim());
                }
                catch(NumberFormatException exceptNumberFormat)
                {
                    IO.logger.log(Level.WARNING, "Number format exception reading data from parameter 'name'", exceptNumberFormat);
                }
            }
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0;
        }

        if (IO.staticTrue)
        {
            /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
            data--;
            int result = (int)(data);
            IO.writeLine("result: " + result);
        }
    }
}