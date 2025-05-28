/*
 * @description Public static fields should be marked final.  If they are not, they
 * may be manipulated in unexpected ways.
 *  
 * This class contains the "bad" version.  
 * There is no need to implement the bad() and good() methods in this test case.
 * 
 * */

package testcases.CWE500_Public_Static_Field_Not_Final;

import testcasesupport.*;

public class CWE500_Public_Static_Field_Not_Final__String_01_bad extends AbstractTestCaseClassIssueBad implements Cloneable 
{
    /* FLAW: public static fields should be marked final */
    public static String DEFAULT_ERROR = "The value you entered was not understood.  Please try again.";
    
    public void bad() 
    {    
        IO.writeLine(DEFAULT_ERROR);
    }
}