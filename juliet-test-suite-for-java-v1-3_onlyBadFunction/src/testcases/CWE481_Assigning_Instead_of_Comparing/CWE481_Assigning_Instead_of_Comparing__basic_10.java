/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE481_Assigning_Instead_of_Comparing__basic_10.java
Label Definition File: CWE481_Assigning_Instead_of_Comparing__basic.label.xml
Template File: point-flaw-10.tmpl.java
*/
/*
* @description
* CWE: 481 Assigning Instead of Comparing
* Sinks:
*    GoodSink: Comparing
*    BadSink : Assigning instead of comparing
* Flow Variant: 10 Control flow: if(IO.staticTrue) and if(IO.staticFalse)
*
* */

package testcases.CWE481_Assigning_Instead_of_Comparing;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE481_Assigning_Instead_of_Comparing__basic_10 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (IO.staticTrue)
        {
            int zeroOrOne = (new SecureRandom()).nextInt(2);
            boolean isZero = (zeroOrOne == 0);
            if(isZero = true) /* FLAW: should be == and INCIDENTIAL CWE 571 Expression Is Always True */
            {
                IO.writeLine("zeroOrOne is 0");
            }
            IO.writeLine("isZero is: " + isZero);
        }
    }
}