/*
 * @description Missing Release of Resource After Effective Lifetime.  Performs some, but not all, necessary resource cleanup (InputStreamReader is not closed).
 * 
 * */

package testcases.CWE772_Missing_Release_of_Resource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.logging.Level;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE772_Missing_Release_of_Resource__console_InputStreamReader_01 extends AbstractTestCase 
{    
    public void bad()
    {
        BufferedReader readerBuffered = null;
        InputStreamReader readerInputStream = null;
        try
        {
            readerInputStream = new InputStreamReader(System.in, "UTF-8");
            readerBuffered = new BufferedReader(readerInputStream);
            String readString = readerBuffered.readLine();
            
            IO.writeLine(readString);
        }
        catch (UnsupportedEncodingException exceptUnsupportedEncoding)
        {
            IO.logger.log(Level.WARNING, "Encoding is not supported!", exceptUnsupportedEncoding);
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
        }
        
        /* FLAW: Streams are not closed */
    }
}