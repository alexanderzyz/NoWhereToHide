/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_From_Return__System_getProperty_trim_16.java
Label Definition File: CWE690_NULL_Deref_From_Return.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
* BadSource: System_getProperty Set data to return of System.getProperty
* GoodSource: Set data to fixed, non-null String
* Sinks: trim
*    GoodSink: Check data for null before calling trim()
*    BadSink : Call trim() on possibly null object
* Flow Variant: 16 Control flow: while(true)
*
* */

package testcases.CWE690_NULL_Deref_From_Return;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE690_NULL_Deref_From_Return__System_getProperty_trim_16 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String data;

        while (true)
        {
            /* POTENTIAL FLAW: data may be set to null */
            data = System.getProperty("CWE690");
            break;
        }

        while (true)
        {
            /* POTENTIAL FLAW: data could be null */
            String stringTrimmed = data.trim();
            IO.writeLine(stringTrimmed);
            break;
        }
    }
}