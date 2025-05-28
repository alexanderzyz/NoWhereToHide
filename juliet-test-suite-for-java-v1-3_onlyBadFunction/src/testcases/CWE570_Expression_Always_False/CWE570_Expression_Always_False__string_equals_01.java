/*
 * @description statement always evaluates to false
 * 
 * */
package testcases.CWE570_Expression_Always_False;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Level;

public class CWE570_Expression_Always_False__string_equals_01 extends AbstractTestCase 
{
    public void bad()
    {
        String stringFalse = "false";
        /* FLAW: always evaluates to false */
        if (stringFalse.equals("true"))
        {
            IO.writeLine("never prints");
        }
    }
}