/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE23_Relative_Path_Traversal__Property_68a.java
Label Definition File: CWE23_Relative_Path_Traversal.label.xml
Template File: sources-sink-68a.tmpl.java
*/
/*
 * @description
 * CWE: 23 Relative Path Traversal
 * BadSource: Property Read data from a system property
 * GoodSource: A hardcoded string
 * BadSink: readFile no validation
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE23_Relative_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

public class CWE23_Relative_Path_Traversal__Property_68a extends AbstractTestCase
{
    public static String data;

    public void bad() throws Throwable
    {

        /* get system property user.home */
        /* POTENTIAL FLAW: Read data from a system property */
        data = System.getProperty("user.home");

        (new CWE23_Relative_Path_Traversal__Property_68b()).badSink();
    }
}