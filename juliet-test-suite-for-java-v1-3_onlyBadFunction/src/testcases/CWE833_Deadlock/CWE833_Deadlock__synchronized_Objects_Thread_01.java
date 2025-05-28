/*
 * @description Demonstrates a deadlock caused by synchronizing on objects in a different order in different functions in multithreaded code that accesses shared variables.
 * 
 * */
package testcases.CWE833_Deadlock;

import java.util.logging.Level;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE833_Deadlock__synchronized_Objects_Thread_01 extends AbstractTestCase 
{
    /* bad(): Synchronize on objects in different order in helperAddBad and helperMultiplyBad, causing a deadlock */
    static private int intBadNumber1 = 3;
    static private final Object BAD_NUMBER1_LOCK = new Object();

    static private int intBadNumber2 = 5;
    static private final Object BAD_NUMBER2_LOCK = new Object();

    static public void helperAddBad()
    {
        synchronized(BAD_NUMBER1_LOCK) 
        {
            try 
            { 
                Thread.sleep(1000); /* sleep for a bit to allow a context switch or the other thread to "catch up" */
            } 
            catch (InterruptedException exceptInterrupted) 
            {
                IO.logger.log(Level.WARNING, "Sleep Interrupted", exceptInterrupted);
            }
            
            synchronized(BAD_NUMBER2_LOCK) 
            {
                intBadNumber1 = intBadNumber1 + intBadNumber2;
            }
        }
    }

    static public void helperMultiplyBad()
    {
        /* FLAW: Synchronize on objects in the opposite order as in helperAddBad() */
        synchronized(BAD_NUMBER2_LOCK) 
        { 
            try 
            { 
                Thread.sleep(1000); /* sleep for a bit to allow a context switch or the other thread to "catch up" */
            } 
            catch (InterruptedException exceptInterrupted) 
            {
                IO.logger.log(Level.WARNING, "Sleep Interrupted", exceptInterrupted);
            }
            
            synchronized(BAD_NUMBER1_LOCK) 
            {
                intBadNumber1 = intBadNumber1 * intBadNumber2;
            }
        }
    }

    public void bad() throws Throwable 
    {
        /* Create threads */
        Thread threadOne = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE833_Deadlock__synchronized_Objects_Thread_01.helperAddBad(); 
            }
        });
        
        Thread threadTwo = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE833_Deadlock__synchronized_Objects_Thread_01.helperMultiplyBad(); 
            }
        });

        /* Start threads */
        threadOne.start();
        threadTwo.start();

        /* Wait for threads to finish (though they never will since they are deadlocked) */
        threadOne.join();
        threadTwo.join();

        /* write output */
        IO.writeLine(intBadNumber1);
    }
}