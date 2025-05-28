/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE506_Embedded_Malicious_Code__file_properties_06.java
Label Definition File: CWE506_Embedded_Malicious_Code.label.xml
Template File: point-flaw-06.tmpl.java
*/
/*
* @description
* CWE: 506 Embedded Malicious Code
* Sinks: file_properties
*    GoodSink: Do not modify any file properties
*    BadSink : Alter file property Last Modified
* Flow Variant: 06 Control flow: if(PRIVATE_STATIC_FINAL_FIVE==5) and if(PRIVATE_STATIC_FINAL_FIVE!=5)
*
* */

package testcases.CWE506_Embedded_Malicious_Code;

import testcasesupport.*;

import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

import java.util.logging.Level;

public class CWE506_Embedded_Malicious_Code__file_properties_06 extends AbstractTestCase
{
    /* The variable below is declared "final", so a tool should be able
     * to identify that reads of this will always give its initialized
     * value.
     */
    private static final int PRIVATE_STATIC_FINAL_FIVE = 5;

    public void bad() throws Throwable
    {
        if (PRIVATE_STATIC_FINAL_FIVE == 5)
        {
            FileOutputStream streamFileOutput = null;
            try
            {
                String path = "C:\\test_bad.txt";
                File file = new File(path);
                long lastModified = file.lastModified();
                streamFileOutput = new FileOutputStream(file);
                streamFileOutput.write("This is a new line".getBytes("UTF-8"));
                /* INCIDENTAL: CWE 252 - Unchecked Return Value - some tools report
                 * an unchecked return value from setLastModified, but this is intentional as
                 * this method call is supposed to be "hidden" in the code
                 */
                /* FLAW: altering file properties */
                file.setLastModified(lastModified - 10000L);
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "File I/O error", exceptIO);
            }
            finally
            {
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
        }
    }
}