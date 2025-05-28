/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE476_NULL_Pointer_Dereference__null_check_after_deref_01.java
Label Definition File: CWE476_NULL_Pointer_Dereference.pointflaw.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 476 NULL Pointer Dereference
* Sinks: null_check_after_deref
*    GoodSink: Do not check for null after the object has been dereferenced
*    BadSink : Check for null after the object has already been dereferenced
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE476_NULL_Pointer_Dereference;

import testcasesupport.*;

public class CWE476_NULL_Pointer_Dereference__null_check_after_deref_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        {
            String myString = null;
            myString = "Hello";

            IO.writeLine(myString.length());

            /* FLAW: Check for null after dereferencing the object. This null check is unnecessary. */
            if (myString != null)
            {
                myString = "my, how I've changed";
            }

            IO.writeLine(myString.length());
        }

    }
}