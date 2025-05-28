/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE477_Obsolete_Functions__URLEncoder_encode_Servlet_11.java
Label Definition File: CWE477_Obsolete_Functions.label.xml
Template File: point-flaw-11.tmpl.java
*/
/*
* @description
* CWE: 477 Use of Obsolete Functions
* Sinks: URLEncoder_encode_Servlet
*    GoodSink: Use of preferred java.net.URLEncoder.encode(String, String)
*    BadSink : Use of deprecated java.net.URLEncoder.encode(String)
* Flow Variant: 11 Control flow: if(IO.staticReturnsTrue()) and if(IO.staticReturnsFalse())
*
* */

package testcases.CWE477_Obsolete_Functions;

import testcasesupport.*;

import java.net.URLEncoder;
import javax.servlet.http.*;

public class CWE477_Obsolete_Functions__URLEncoder_encode_Servlet_11 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (IO.staticReturnsTrue())
        {
            /* FLAW: Use of deprecated URLEncoder.encode(String s) method */
            response.getWriter().println(URLEncoder.encode("abc|1 $#@<><()"));
        }
    }
}