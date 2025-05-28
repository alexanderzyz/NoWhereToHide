/*
 * @description Demonstrates lack of any synchronization or locks in a Servlet that updates a shared variable.  Servlets are inherently multithreaded, so we don't need to actually start threads in the bad() and goodX() functions.
 * 
 * */

package testcases.CWE609_Double_Checked_Locking;

import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testcasesupport.AbstractTestCaseServlet;

public class CWE609_Double_Checked_Locking__Servlet_01 extends AbstractTestCaseServlet 
{
    private static final long serialVersionUID = 1L;

    /* Bad() - Use of Double Checked Locking */
    private static String stringBad = null;
    
    /* FLAW: Insufficient "Double-Checked Locking" in this method - in certain circumstances, this can lead to stringBad being initialized twice.
	 * See http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html for details. */
    public static String helperBad() 
    { 
        if (stringBad == null)
        {
            synchronized(CWE609_Double_Checked_Locking__Servlet_01.class)
            {
                if (stringBad == null)
                {
                    stringBad = "stringBad";
                }
            }
        }
        return stringBad;
    }
  
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable 
    {
        response.getWriter().write(helperBad());
    }
}