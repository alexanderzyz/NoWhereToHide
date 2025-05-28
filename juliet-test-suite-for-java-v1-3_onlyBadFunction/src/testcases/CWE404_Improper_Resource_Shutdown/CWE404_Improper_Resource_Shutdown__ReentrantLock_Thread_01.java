/*
 * @description Improper release of lock
 * 
 * */
package testcases.CWE404_Improper_Resource_Shutdown;

import java.util.concurrent.locks.ReentrantLock;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE404_Improper_Resource_Shutdown__ReentrantLock_Thread_01 extends AbstractTestCase 
{
    static private int intBadNumber = 3;
    static private final ReentrantLock BAD_REENTRANT_LOCK = new ReentrantLock();

    static public void helperBad()
    {
        BAD_REENTRANT_LOCK.lock();
        
        intBadNumber++;
        
        IO.writeLine(intBadNumber);
        
        /* FLAW: lock should be unlocked in a finally block */
        BAD_REENTRANT_LOCK.unlock();       
    }
    
    public void bad() throws Throwable 
    {
        helperBad();
    }
}