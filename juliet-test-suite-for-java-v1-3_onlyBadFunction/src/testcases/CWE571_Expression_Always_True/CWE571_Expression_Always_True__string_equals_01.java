/*
 * @description statement always evaluates to true
 * 
 * */
package testcases.CWE571_Expression_Always_True;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Level;

public class CWE571_Expression_Always_True__string_equals_01 extends AbstractTestCase 
{
    public void bad()
    {
        String stringTrue = "true";
        /* FLAW: always evaluates to true */
        if (stringTrue.equals("true"))
        {
            IO.writeLine("always prints");
        }
    }
}