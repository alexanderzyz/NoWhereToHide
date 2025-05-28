/*
 * @description Demonstrates use of lock() more times than unlock() in multithreaded code that accesses a shared variable.
 * 
 * */
package testcases.CWE764_Multiple_Locks;

import java.util.concurrent.locks.ReentrantLock;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE764_Multiple_Locks__ReentrantLock_Thread_01 extends AbstractTestCase 
{
    /* bad(): Use lock() twice and unlock() once */
    static private int intBad = 1;
    static private final ReentrantLock REENTRANT_LOCK_BAD = new ReentrantLock();

    static public void helperBad() 
    {
        REENTRANT_LOCK_BAD.lock(); 
        REENTRANT_LOCK_BAD.lock(); /* FLAW: Code uses lock() twice (and unlock() once), so the second thread will never be able to get lock */

        /* good practice is to unlock() in a finally block, see
		 * http://download.oracle.com/javase/6/docs/api/java/util/concurrent/locks/ReentrantLock.html */
        try
        { 
            intBad = intBad * 2;
        } 
        finally 
        {
            REENTRANT_LOCK_BAD.unlock(); /* Only one unlock(), so the lock will still be held when the thread ends, meaning no other threads can get the lock */
        }
    }

    public void bad() throws Throwable 
    {
        /* Create threads */
        Thread threadOne = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE764_Multiple_Locks__ReentrantLock_Thread_01.helperBad(); 
            }
        });
       
        Thread threadTwo = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE764_Multiple_Locks__ReentrantLock_Thread_01.helperBad(); 
            }
        });

        /* Start threads */
        threadOne.start();
        threadTwo.start();

        /* Wait for threads to finish (though they never will because the second thread will never be able to get the lock that the first thread
		 * incorrectly locked twice) */
        threadOne.join();
        threadTwo.join();

        /* Write output */
        IO.writeLine(intBad);  
    }
}