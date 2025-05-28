/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE563_Unused_Variable__unused_value_int_12.java
Label Definition File: CWE563_Unused_Variable__unused_value.label.xml
Template File: sources-sinks-12.tmpl.java
*/
/*
* @description
* CWE: 563 Unused Variable
* BadSource:  Initialize data
* GoodSource: Initialize and use data
* Sinks:
*    GoodSink: Use data
*    BadSink : re-initialize and use data
* Flow Variant: 12 Control flow: if(IO.staticReturnsTrueOrFalse())
*
* */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

public class CWE563_Unused_Variable__unused_value_int_12 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int data;
        if(IO.staticReturnsTrueOrFalse())
        {
            /* POTENTIAL FLAW: Initialize, but do not use data */
            data = 5;
        }
        else
        {

            /* FIX: Initialize and use data before it is overwritten */

            data = 5;

            IO.writeLine("" + data);

        }

        if(IO.staticReturnsTrueOrFalse())
        {
            /* POTENTIAL FLAW: Possibly over-write the initial value of data before using it */
            data = 10;
            IO.writeLine("" + data);
        }
        else
        {

            /* FIX: Use data without over-writing its value */

            IO.writeLine("" + data);

        }
    }
}