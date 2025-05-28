/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE378_Temporary_File_Creation_With_Insecure_Perms__basic_16.java
Label Definition File: CWE378_Temporary_File_Creation_With_Insecure_Perms__basic.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 378 Explicitly set permissions on files
* Sinks:
*    GoodSink: Restrict permissions on file
*    BadSink : Permissions never set on file
* Flow Variant: 16 Control flow: while(true)
*
* */

package testcases.CWE378_Temporary_File_Creation_With_Insecure_Perms;

import testcasesupport.*;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

import java.util.logging.Level;

public class CWE378_Temporary_File_Creation_With_Insecure_Perms__basic_16 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        while(true)
        {
            FileOutputStream streamFileOutput = null;
            OutputStreamWriter writerOutputStream = null;
            BufferedWriter writerBuffered = null;
            File tempFile = null;
            try
            {
                tempFile = File.createTempFile("temp", "1234");
                /* FLAW: Permissions never set on file */
                /* Write something to the file */
                streamFileOutput = new FileOutputStream(tempFile);
                writerOutputStream = new OutputStreamWriter(streamFileOutput, "UTF-8");
                writerBuffered = new BufferedWriter(writerOutputStream);
                writerBuffered.write(42);
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error writing to temporary file", exceptIO);
            }
            finally
            {
                /* Delete the temporary file */
                if (tempFile.exists())
                {
                    tempFile.delete();
                }

                try
                {
                    if (writerBuffered != null)
                    {
                        writerBuffered.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedWriter", exceptIO);
                }

                try
                {
                    if (writerOutputStream != null)
                    {
                        writerOutputStream.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", exceptIO);
                }

                try
                {
                    if (streamFileOutput != null)
                    {
                        streamFileOutput.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileOutputStream", exceptIO);
                }
            }
            break;
        }
    }
}