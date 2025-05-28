/*
 * @description Unused private class member variable
 * 
 * */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

public class CWE563_Unused_Variable__unused_private_member_variable_01_bad extends AbstractTestCaseClassIssueBad 
{
    private int intBad = 1; /* FLAW: This member is never used */

    public void bad() 
    {    
        /* FLAW: Don't use intBad */
        IO.writeLine("" + 5);
    }
}