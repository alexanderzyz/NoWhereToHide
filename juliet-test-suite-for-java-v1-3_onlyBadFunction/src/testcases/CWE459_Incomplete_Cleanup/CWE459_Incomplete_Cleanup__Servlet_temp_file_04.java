/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE459_Incomplete_Cleanup__Servlet_temp_file_04.java
Label Definition File: CWE459_Incomplete_Cleanup.label.xml
Template File: point-flaw-04.tmpl.java
*/
/*
* @description
* CWE: 459 Incomplete Cleanup
* Sinks: Servlet_temp_file
*    GoodSink: Delete the temporary file manually
*    BadSink : Use .deleteOnExit() to delete the temp file, potentially leaving the file in existence for a long time
* Flow Variant: 04 Control flow: if(PRIVATE_STATIC_FINAL_TRUE) and if(PRIVATE_STATIC_FINAL_FALSE)
*
* */

package testcases.CWE459_Incomplete_Cleanup;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.File;
import java.io.IOException;

import java.util.logging.Level;

public class CWE459_Incomplete_Cleanup__Servlet_temp_file_04 extends AbstractTestCaseServlet
{
    /* The two variables below are declared "final", so a tool should
     * be able to identify that reads of these will always return their
     * initialized values.
     */
    private static final boolean PRIVATE_STATIC_FINAL_TRUE = true;
    private static final boolean PRIVATE_STATIC_FINAL_FALSE = false;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (PRIVATE_STATIC_FINAL_TRUE)
        {
            File tempFile = null;
            try
            {
                tempFile = File.createTempFile("temp", "1234");
                /* FLAW: Delete the temp file by using .deleteOnExit(). Using this method to delete
                 * the file for a Servlet can keep the file in existence for a long time as it will not
                 * be deleted until the JVM is shut down. */
                tempFile.deleteOnExit();
                /* Set the permissions to avoid insecure temporary file incidentals  */
                if (!tempFile.setWritable(true, true))
                {
                    IO.logger.log(Level.WARNING, "Could not set Writable permissions");
                }
                if (!tempFile.setReadable(true, true))
                {
                    IO.logger.log(Level.WARNING, "Could not set Readable permissions");
                }
                if (!tempFile.setExecutable(false))
                {
                    IO.logger.log(Level.WARNING, "Could not set Executable permissions");
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Could not create temporary file", exceptIO);
            }
        }
    }
}