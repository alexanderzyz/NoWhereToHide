/*
 * @description Unused method parameter value
 *
 * */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

public class CWE563_Unused_Variable__unused_parameter_value_01 extends AbstractTestCase 
{
    private void helperBad(int intBad) 
    {
        /* FLAW: Overwrite the initial value of the parameter variable before use */
        intBad = 0;
        IO.writeLine("" + intBad);
    }
    
    public void bad()
    {
        helperBad(5);
    }
}