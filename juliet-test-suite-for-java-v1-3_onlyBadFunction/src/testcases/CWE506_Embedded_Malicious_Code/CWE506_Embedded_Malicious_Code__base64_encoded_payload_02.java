/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE506_Embedded_Malicious_Code__base64_encoded_payload_02.java
Label Definition File: CWE506_Embedded_Malicious_Code.label.xml
Template File: point-flaw-02.tmpl.java
*/
/*
* @description
* CWE: 506 Embedded Malicious Code
* Sinks: base64_encoded_payload
*    GoodSink: Use a plaintext command
*    BadSink : Use a base64 encoded payload in an attempt to hide the command
* Flow Variant: 02 Control flow: if(true) and if(false)
*
* */

package testcases.CWE506_Embedded_Malicious_Code;

import testcasesupport.*;

import org.apache.commons.codec.binary.Base64;

import java.io.IOException;

import java.util.logging.Level;

public class CWE506_Embedded_Malicious_Code__base64_encoded_payload_02 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (true)
        {
            /* FLAW: encoded "calc.exe" */
            String encodedPayload = "Y2FsYy5leGU=";
            try
            {
                Runtime.getRuntime().exec(new String(Base64.decodeBase64(encodedPayload), "UTF-8"));
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error executing command", exceptIO);
            }
        }
    }
}