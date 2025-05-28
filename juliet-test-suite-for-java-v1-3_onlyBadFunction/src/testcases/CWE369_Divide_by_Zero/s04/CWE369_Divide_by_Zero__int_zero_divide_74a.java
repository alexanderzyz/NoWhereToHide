/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__int_zero_divide_74a.java
Label Definition File: CWE369_Divide_by_Zero__int.label.xml
Template File: sources-sinks-74a.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: zero Set data to a hardcoded value of zero
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: divide
 *    GoodSink: Check for zero before dividing
 *    BadSink : Dividing by a value that may be zero
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE369_Divide_by_Zero.s04;
import testcasesupport.*;
import java.util.HashMap;

import javax.servlet.http.*;

public class CWE369_Divide_by_Zero__int_zero_divide_74a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int data;

        data = 0; /* POTENTIAL FLAW: data is set to zero */

        HashMap<Integer,Integer> dataHashMap = new HashMap<Integer,Integer>();
        dataHashMap.put(0, data);
        dataHashMap.put(1, data);
        dataHashMap.put(2, data);
        (new CWE369_Divide_by_Zero__int_zero_divide_74b()).badSink(dataHashMap  );
    }
}