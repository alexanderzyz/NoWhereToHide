/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE252_Unchecked_Return_Value__FileInputStream_07.java
Label Definition File: CWE252_Unchecked_Return_Value__FileInputStream.label.xml
Template File: point-flaw-07.tmpl.java
*/
/*
* @description
* CWE: 252 Unchecked Return Value
* Sinks:
*    GoodSink: Check the return value from FileInputStream.read() and handle possible errors
*    BadSink : Do not check the return value of FileInputStream.read()
* Flow Variant: 07 Control flow: if(privateFive==5) and if(privateFive!=5)
*
* */

package testcases.CWE252_Unchecked_Return_Value;

import testcasesupport.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.logging.Level;

public class CWE252_Unchecked_Return_Value__FileInputStream_07 extends AbstractTestCase
{
    /* The variable below is not declared "final", but is never assigned
     * any other value so a tool should be able to identify that reads of
     * this will always give its initialized value.
     */
    private int privateFive = 5;

    public void bad() throws Throwable
    {
        if (privateFive == 5)
        {
            FileInputStream streamFileInput = null;
            try
            {
                int bytesToRead = 1024;
                byte[] byteArray = new byte[bytesToRead];
                streamFileInput = new FileInputStream("c:\\file.txt");
                streamFileInput.read(byteArray);
                /* FLAW: Do not check the return value of read() */
                IO.writeLine(new String(byteArray, "UTF-8"));
            }
            catch(FileNotFoundException exceptFileNotFound)
            {
                IO.logger.log(Level.WARNING, "FileNotFoundException opening file", exceptFileNotFound);
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "IOException reading file", exceptIO);
            }
            finally
            {
                try
                {
                    if(streamFileInput != null)
                    {
                        streamFileInput.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "IOException closing FileInputStream", exceptIO);
                }
            }
        }
    }
}