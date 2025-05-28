/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE396_Catch_Generic_Exception__Throwable_01.java
Label Definition File: CWE396_Catch_Generic_Exception.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 396 An overly broad catch statement may cause errors in program execution if unexpected exceptions are thrown
* Sinks: Throwable
*    GoodSink: Catch specific exception type (NumberFormatException)
*    BadSink : Catch Throwable, which is overly generic
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE396_Catch_Generic_Exception;

import testcasesupport.*;

public class CWE396_Catch_Generic_Exception__Throwable_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        try
        {
            Integer.parseInt("Test"); /* Will throw NumberFormatException */
        }
        catch (Throwable throwable) /* FLAW: Catch Throwable, which is overly generic */
        {
            IO.writeLine("Caught Throwable");
            throw throwable; /* Rethrow */
        }

    }
}