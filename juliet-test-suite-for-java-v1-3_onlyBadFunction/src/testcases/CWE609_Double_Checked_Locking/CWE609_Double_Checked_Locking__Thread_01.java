/*
 * @description Use of "Double Checked Locking" which can fail in certain circumstances.  See http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html for details. 
 * 
 * */

package testcases.CWE609_Double_Checked_Locking;

import java.util.concurrent.locks.ReentrantLock;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE609_Double_Checked_Locking__Thread_01 extends AbstractTestCase 
{
    /* Bad() - Use of Double Checked Locking */
    private static String stringBad = null;
    
    /* FLAW: Insufficient "Double-Checked Locking" in this method - in certain circumstances, this can lead to stringBad being initialized twice.
	 * See http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html for details. */
    public static String helperBad() 
    { 
        if (stringBad == null)
        {
            synchronized(CWE609_Double_Checked_Locking__Thread_01.class)
            {
                if (stringBad == null)
                {
                    stringBad = "stringBad";
                }
            }
        }
        return stringBad;
    }
    
    public void bad() throws InterruptedException
    { 
        /* Create threads */
        Thread threadOne = new Thread(new Runnable() 
        {
            public void run() 
            { 
                IO.writeLine(CWE609_Double_Checked_Locking__Thread_01.helperBad()); 
            }
        });
        
        Thread threadTwo = new Thread(new Runnable() 
        {
            public void run() 
            { 
                IO.writeLine(CWE609_Double_Checked_Locking__Thread_01.helperBad()); 
            }
        });
        
        /* Start threads */
        threadOne.start();
        threadTwo.start();
        
        /* Wait for threads to finish */
        threadOne.join();
        threadTwo.join();
    }
}