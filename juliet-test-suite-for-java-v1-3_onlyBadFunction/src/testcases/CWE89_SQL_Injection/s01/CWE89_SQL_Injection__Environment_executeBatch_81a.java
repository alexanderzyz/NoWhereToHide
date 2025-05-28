/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__Environment_executeBatch_81a.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-81a.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded string
 * Sinks: executeBatch
 *    GoodSink: Use prepared statement and executeBatch (properly)
 *    BadSink : data concatenated into SQL statement used in executeBatch(), which could result in SQL Injection
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE89_SQL_Injection.s01;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE89_SQL_Injection__Environment_executeBatch_81a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String data;

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read data from an environment variable */
        data = System.getenv("ADD");

        CWE89_SQL_Injection__Environment_executeBatch_81_base baseObject = new CWE89_SQL_Injection__Environment_executeBatch_81_bad();
        baseObject.action(data );
    }
}