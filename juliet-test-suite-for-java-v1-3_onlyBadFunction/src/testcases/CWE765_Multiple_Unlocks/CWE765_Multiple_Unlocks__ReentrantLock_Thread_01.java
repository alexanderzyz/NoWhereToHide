/*
 * @description Demonstrates use of unlock() more times than lock() in multithreaded code that accesses a shared variable.
 * 
 * */
package testcases.CWE765_Multiple_Unlocks;

import java.util.concurrent.locks.ReentrantLock;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE765_Multiple_Unlocks__ReentrantLock_Thread_01 extends AbstractTestCase 
{
    /* bad(): Use lock() once and unlock() twice */
    static private int intBad = 1;
    static private final ReentrantLock REENTRANT_LOCK_BAD = new ReentrantLock();

    static public void helperBad() 
    {
        REENTRANT_LOCK_BAD.lock(); 

        /* good practice is to unlock() in a finally block, see
		 * http://download.oracle.com/javase/6/docs/api/java/util/concurrent/locks/ReentrantLock.html */
        try
        { 
            intBad = intBad * 2;
        } 
        finally 
        {
            REENTRANT_LOCK_BAD.unlock();    
            REENTRANT_LOCK_BAD.unlock(); /* FLAW: Code uses unlock() twice (and lock() once), which will throw an IllegalMonitorStateException */
        }
    }

    public void bad() throws Throwable 
    {
        /* Create threads */
        Thread threadOne = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE765_Multiple_Unlocks__ReentrantLock_Thread_01.helperBad(); 
            }
        });
        
        Thread threadTwo = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE765_Multiple_Unlocks__ReentrantLock_Thread_01.helperBad(); 
            }
        });

        /* Start threads */
        threadOne.start();
        threadTwo.start();

        /* Wait for threads to finish */
        threadOne.join();
        threadTwo.join();

        /* Write output */
        IO.writeLine(intBad);  
    }
}