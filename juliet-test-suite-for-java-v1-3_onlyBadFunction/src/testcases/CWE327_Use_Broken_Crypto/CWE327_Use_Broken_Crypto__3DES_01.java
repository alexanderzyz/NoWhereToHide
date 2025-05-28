/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE327_Use_Broken_Crypto__3DES_01.java
Label Definition File: CWE327_Use_Broken_Crypto.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 327 Use of Broken or Risky Cryptographic Algorithm
* Sinks: 3DES
*    GoodSink: use AES
*    BadSink : use 3DES
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE327_Use_Broken_Crypto;

import testcasesupport.*;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class CWE327_Use_Broken_Crypto__3DES_01 extends AbstractTestCase
{
    public void bad() throws Throwable
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