/*
 * @description A class defines hashcode() but not equals(), which possibly breaks a 
 * java invariant that if a.equals(b) == true then a.hashCode() == b.hashCode()
 * 
 * This is the "bad" version, which defines both hashCode(), but not equals().
 * There is no need to implement the bad() and good() methods in this test case.
 * 
 * */

package testcases.CWE581_Object_Model_Violation;

import testcasesupport.*;

public class CWE581_Object_Model_Violation__equals_01_bad extends AbstractTestCaseClassIssueBad 
{
    private String message = "test";
    public void setMessage(String message) 
    {
        this.message = message;
    }
    
    /* FLAW: hashcode() is defined but equals() is not */
    private int seed = 12345; /* Helps to prevent collisions */
    
    public int hashCode() 
    {
        return message.hashCode() + seed;
    }
    
    public void bad() 
    { 
        /* Class-based issue */
    }
}