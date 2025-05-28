/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE486_Compare_Classes_by_Name__basic_10.java
Label Definition File: CWE486_Compare_Classes_by_Name__basic.label.xml
Template File: point-flaw-10.tmpl.java
*/
/*
* @description
* CWE: 486 Compare Classes by Name
* Sinks:
*    GoodSink: properly compare class
*    BadSink : Compare class names
* Flow Variant: 10 Control flow: if(IO.staticTrue) and if(IO.staticFalse)
*
* */

package testcases.CWE486_Compare_Classes_by_Name;

import testcasesupport.*;

public class CWE486_Compare_Classes_by_Name__basic_10 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (IO.staticTrue)
        {
            /* FLAW: Differentiating by name is not enough, since different classes in different packages may use the same name */
            testcases.CWE486_Compare_Classes_by_Name.HelperClass.CWE486_Compare_Classes_by_Name__Helper helperClass = new testcases.CWE486_Compare_Classes_by_Name.HelperClass.CWE486_Compare_Classes_by_Name__Helper();
            testcases.CWE486_Compare_Classes_by_Name.CWE486_Compare_Classes_by_Name__Helper helperClassRoot = new testcases.CWE486_Compare_Classes_by_Name.CWE486_Compare_Classes_by_Name__Helper();
            if (helperClassRoot.getClass().getSimpleName().equals(helperClass.getClass().getSimpleName()))
            {
                IO.writeLine("Classes are the same");
            }
            else
            {
                /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
                IO.writeLine("Classes are different");
            }
        }
    }
}