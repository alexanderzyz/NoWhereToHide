/*
 * @description Demonstrates a synchronized block that is empty (and therefore allowing unsynchronized updates to a shared variable). 
 * 
 * */

package testcases.CWE585_Empty_Sync_Block;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE585_Empty_Sync_Block__Thread_01 extends AbstractTestCase 
{
    /* bad(): Empty synchronized block */
    static private int intBad = 1;

    static public void helperBad()
    {
        synchronized(CWE585_Empty_Sync_Block__Thread_01.class) 
        {
            /* FLAW: empty synchronized block - should cover whole method */
        }
    
        intBad = intBad * 2;
    }

    public void bad() throws InterruptedException 
    {
        /* Create threads */
        Thread threadOne = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE585_Empty_Sync_Block__Thread_01.helperBad(); 
            }
        });
        
        Thread threadTwo = new Thread(new Runnable() 
        {
            public void run() 
            { 
                CWE585_Empty_Sync_Block__Thread_01.helperBad(); 
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