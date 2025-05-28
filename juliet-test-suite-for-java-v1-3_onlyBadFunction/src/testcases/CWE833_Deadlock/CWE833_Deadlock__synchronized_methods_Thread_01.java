/*
 * @description Demonstrates a deadlock caused by synchronized methods in objects that call one another in multithreaded code.  Implementation based on http://download.oracle.com/javase/tutorial/essential/concurrency/deadlock.html.
 * 
 * */
package testcases.CWE833_Deadlock;

import java.util.logging.Level;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE833_Deadlock__synchronized_methods_Thread_01 extends AbstractTestCase 
{
    /* Bad - Call to a synchronized method on another object while holding lock on this object */
    public synchronized void helperBowBad(CWE833_Deadlock__synchronized_methods_Thread_01 bower) 
    {
        IO.writeLine("helperBowBad");
    
        try 
        { 
            Thread.sleep(1000); /* sleep for a bit to allow a context switch or the other thread to "catch up" */
        } 
        catch (InterruptedException exceptInterrupted) 
        {
            IO.logger.log(Level.WARNING, "Sleep Interrupted", exceptInterrupted);
        }
            
        bower.helperBowBackBad(this); /* FLAW: Call to a synchronized method on another object while holding lock on this object */
    }
    
    public synchronized void helperBowBackBad(CWE833_Deadlock__synchronized_methods_Thread_01 bower) 
    {
        IO.writeLine("helperBowBackBad");
    }

    public void bad() throws InterruptedException 
    {
        /* Create objects */
        final CWE833_Deadlock__synchronized_methods_Thread_01 FINAL_THREAD_ONE = new CWE833_Deadlock__synchronized_methods_Thread_01();
        final CWE833_Deadlock__synchronized_methods_Thread_01 FINAL_THREAD_TWO = new CWE833_Deadlock__synchronized_methods_Thread_01();

        /* Create threads */
        Thread threadOne = new Thread(new Runnable() 
        {
            public void run() 
            { 
                FINAL_THREAD_ONE.helperBowBad(FINAL_THREAD_TWO); 
            }
        });
        
        Thread threadTwo = new Thread(new Runnable() 
        {
            public void run() 
            { 
                FINAL_THREAD_TWO.helperBowBad(FINAL_THREAD_ONE); 
            }
        });

        /* Start threads */
        threadOne.start();
        threadTwo.start();
          
        /* Wait for threads to finish (though they never will since they are deadlocked) */
        threadOne.join();
        threadTwo.join();
    }
}