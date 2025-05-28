/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE546_Suspicious_Comment__LATER_01.java
Label Definition File: CWE546_Suspicious_Comment.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 546 Suspicious Comment
* Sinks: LATER
*    GoodSink: does not contain suspicious comment
*    BadSink : does not contain a suspicious comment
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE546_Suspicious_Comment;

import testcasesupport.*;

public class CWE546_Suspicious_Comment__LATER_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        /* FLAW: This is the suspicious comment */
        /* LATER: There is a bug at this location...I'm not sure why! */
        IO.writeLine("This a test of the emergency broadcast system");

    }
}