/*
 * @description Declare that the function throws "Throwable" rather than a specific exception.  In this test case, we don't necessarily throw an exception to differentiate it from other test cases.
 *
 * */

package testcases.CWE397_Throw_Generic;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.logging.Level;

public class CWE397_Throw_Generic__declare_Throwable_01 extends AbstractTestCase 
{
    public void bad() throws Throwable /* FLAW: Method is declared as throwing Throwable, which is very generic */ 
    {
        FileInputStream streamFileInput = new FileInputStream("filename.txt"); /* May throw a FileNotFoundException */
        IO.writeLine("File 'filename.txt' exists");
        
        try 
        {
            streamFileInput.close();
        } 
        catch (IOException exceptIO) 
        {
            IO.logger.log(Level.WARNING, "Error closing FileInputStream", exceptIO);
        }
    }
}