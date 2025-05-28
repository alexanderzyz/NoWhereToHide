/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE601_Open_Redirect__Servlet_getParameter_Servlet_74a.java
Label Definition File: CWE601_Open_Redirect__Servlet.label.xml
Template File: sources-sink-74a.tmpl.java
*/
/*
 * @description
 * CWE: 601 Open Redirect
 * BadSource: getParameter_Servlet Read data from a querystring using getParameter()
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : place redirect string directly into redirect api call
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE601_Open_Redirect;

import testcasesupport.*;
import java.util.HashMap;

import javax.servlet.http.*;


public class CWE601_Open_Redirect__Servlet_getParameter_Servlet_74a extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Read data from a querystring using getParameter */
        data = request.getParameter("name");

        HashMap<Integer,String> dataHashMap = new HashMap<Integer,String>();
        dataHashMap.put(0, data);
        dataHashMap.put(1, data);
        dataHashMap.put(2, data);
        (new CWE601_Open_Redirect__Servlet_getParameter_Servlet_74b()).badSink(dataHashMap , request, response );
    }
}