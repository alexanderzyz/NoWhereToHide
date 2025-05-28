/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__Servlet_14.java
Label Definition File: CWE400_Resource_Exhaustion__Servlet.label.xml
Template File: point-flaw-14.tmpl.java
*/
/*
* @description
* CWE: 400 Resource Exhaustion
* Sinks:
*    GoodSink: Size of uploaded file restricted to 10 MB
*    BadSink : No restriction on upload size
* Flow Variant: 14 Control flow: if(IO.staticFive==5) and if(IO.staticFive!=5)
*
* */

package testcases.CWE400_Resource_Exhaustion.s02;
import testcasesupport.*;

import javax.servlet.http.*;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;

import java.util.logging.Level;

public class CWE400_Resource_Exhaustion__Servlet_14 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (IO.staticFive == 5)
        {
            /**
             * Inspiration from:
             * http://forums.codecharge.com/posts.php?post_id=44078
             * and
             * http://commons.apache.org/downloads/download_fileupload.cgi
             * class FileUploadBase, method parseRequest()
             * class Streams, method copy()
             *
             * We don't actually parse out the filename or any of the other data since it really
             * doesn't matter for this test. (We don't care if part of the HTTP request ends up in
             * the file.
             *
             * Note that if you try to run this file, you'll always get an exception from the bad method.
             * This is because you've already read the full httprequest stream and stored it into a file.
             * So, expect the bad method to always fail if you directly run this file from eclipse.
             */
            if (request.getContentType() == null || !request.getContentType().contains("multipart/form-data"))
            {
                return;
            }
            FileOutputStream streamFileOutput = null;
            InputStream streamInput = null;
            try
            {
                streamFileOutput = new FileOutputStream("output_bad.dat");
                streamInput = request.getInputStream();
                for (;;)
                {
                    byte[] inputBytes = new byte[1024];
                    int bytesRead = streamInput.read(inputBytes); /* FLAW: no restriction on file size */
                    if (bytesRead == -1)
                    {
                        break;
                    }
                    streamFileOutput.write(inputBytes);
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error!", exceptIO);
            }
            finally
            {
                try
                {
                    if (streamInput != null)
                    {
                        streamInput.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStream", exceptIO);
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
            response.getWriter().write("Uploaded file!");
        }
    }
}