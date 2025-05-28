/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE327_Use_Broken_Crypto__3DES_03.java
Label Definition File: CWE327_Use_Broken_Crypto.label.xml
Template File: point-flaw-03.tmpl.java
*/
/*
* @description
* CWE: 327 Use of Broken or Risky Cryptographic Algorithm
* Sinks: 3DES
*    GoodSink: use AES
*    BadSink : use 3DES
* Flow Variant: 03 Control flow: if(5==5) and if(5!=5)
*
* */

package testcases.CWE327_Use_Broken_Crypto;

import testcasesupport.*;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class CWE327_Use_Broken_Crypto__3DES_03 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (5 == 5)
        {
            final String CIPHER_INPUT = "ABCDEFG123456";
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
            /* Perform initialization of KeyGenerator */
            keyGenerator.init(112);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] byteKey = secretKey.getEncoded();
            /* FLAW: Use a weak crypto algorithm, 3DES */
            SecretKeySpec secretKeySpec = new SecretKeySpec(byteKey, "DESede");
            Cipher tripleDesCipher = Cipher.getInstance("DESede");
            tripleDesCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encrypted = tripleDesCipher.doFinal(CIPHER_INPUT.getBytes("UTF-8"));
            IO.writeLine(IO.toHex(encrypted));
        }
    }
}