/*
 * @description Unused method parameter variable
 *
 * */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

public class CWE563_Unused_Variable__unused_parameter_variable_01 extends AbstractTestCase 
{
    private void helperBad(int intBad) 
    {
        /* FLAW: Do not use the parameter variable intBad */
        IO.writeLine("" + 7);
    }
    
    public void bad()
    {
        helperBad(5);
    }
}