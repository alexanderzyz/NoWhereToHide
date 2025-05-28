/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__Environment_write_74a.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-74a.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: Environment Read count from an environment variable
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: write
 *    GoodSink: Write to a file count number of times, but first validate count
 *    BadSink : Write to a file count number of times
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s01;
import testcasesupport.*;
import java.util.HashMap;

import javax.servlet.http.*;

import java.util.logging.Level;

public class CWE400_Resource_Exhaustion__Environment_write_74a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int count;

        count = Integer.MIN_VALUE; /* Initialize count */

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read count from an environment variable */
        {
            String stringNumber = System.getenv("ADD");
            if (stringNumber != null) // avoid NPD incidental warnings
            {
                try
                {
                    count = Integer.parseInt(stringNumber.trim());
                }
                catch(NumberFormatException exceptNumberFormat)
                {
                    IO.logger.log(Level.WARNING, "Number format exception parsing count from string", exceptNumberFormat);
                }
            }
        }

        HashMap<Integer,Integer> countHashMap = new HashMap<Integer,Integer>();
        countHashMap.put(0, count);
        countHashMap.put(1, count);
        countHashMap.put(2, count);
        (new CWE400_Resource_Exhaustion__Environment_write_74b()).badSink(countHashMap  );
    }
}