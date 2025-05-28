/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE390_Error_Without_Action__mkdirs_01.java
Label Definition File: CWE390_Error_Without_Action.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 390 Detection of Error Condition Without Action
* Sinks: mkdirs
*    GoodSink: Throw Exception if newDirectory cannot be created
*    BadSink : Do nothing if newDirectory cannot be created
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE390_Error_Without_Action;

import testcasesupport.*;

import java.io.File;

public class CWE390_Error_Without_Action__mkdirs_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        File newDirectory = null;

        if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
        {
            /* running on Windows */
            newDirectory = new File("C:\\lvl_1\\lvl_2\\lvl_3\\");
        }
        else
        {
            /* running on non-Windows */
            newDirectory = new File("/home/user/lvl_1/lvl_2/lvl_3/");
        }

        if (!newDirectory.mkdirs())
        {
            /* FLAW: do nothing if newDirectory cannot be created */
        }

    }
}