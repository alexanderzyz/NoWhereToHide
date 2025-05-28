/*
 * @description call an empty function
 * 
 * */
package testcases.CWE398_Poor_Code_Quality;

import testcasesupport.*;

public class CWE398_Poor_Code_Quality__empty_function_01 extends AbstractTestCase 
{
    private void helperBad() 
    {
        /* FLAW: Function does nothing */
    }

    public void bad()
    {
        helperBad();
    }
}