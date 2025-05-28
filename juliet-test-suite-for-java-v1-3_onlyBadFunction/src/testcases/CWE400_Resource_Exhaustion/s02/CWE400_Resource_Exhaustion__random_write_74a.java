/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__random_write_74a.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-74a.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: random Set count to a random value
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: write
 *    GoodSink: Write to a file count number of times, but first validate count
 *    BadSink : Write to a file count number of times
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s02;
import testcasesupport.*;
import java.util.HashMap;

import javax.servlet.http.*;

import java.security.SecureRandom;

public class CWE400_Resource_Exhaustion__random_write_74a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int count;

        /* POTENTIAL FLAW: Set count to a random value */
        count = (new SecureRandom()).nextInt();

        HashMap<Integer,Integer> countHashMap = new HashMap<Integer,Integer>();
        countHashMap.put(0, count);
        countHashMap.put(1, count);
        countHashMap.put(2, count);
        (new CWE400_Resource_Exhaustion__random_write_74b()).badSink(countHashMap  );
    }
}