/*
 * @description Improper Locking
 * 
 * */
package testcases.CWE667_Improper_Locking;

import java.util.concurrent.locks.ReentrantLock;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE667_Improper_Locking__basic_01 extends AbstractTestCase 
{
    static private int intBadNumber = 3;
    static private final ReentrantLock BAD_REENTRANT_LOCK = new ReentrantLock();

    static public void helperBad()
    {
        BAD_REENTRANT_LOCK.lock();
        
        intBadNumber++;
        
        IO.writeLine(intBadNumber);
        
        /* FLAW: lock is not unlocked */
    }
    
    public void bad() throws Throwable 
    {
        helperBad();
    }
}