/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE114_Process_Control__basic_01.java
Label Definition File: CWE114_Process_Control__basic.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 114 Process Control
* Sinks:
*    GoodSink: use System.load() to load a library
*    BadSink : use System.loadLibrary() to load a library
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE114_Process_Control;

import testcasesupport.*;

public class CWE114_Process_Control__basic_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        String libraryName = "test.dll";

        /* FLAW: Attempt to load a library with System.loadLibrary() without
         * the full path to the library. */
        System.loadLibrary(libraryName);

    }
}