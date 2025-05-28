/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE789_Uncontrolled_Mem_Alloc__max_value_ArrayList_72a.java
Label Definition File: CWE789_Uncontrolled_Mem_Alloc.int.label.xml
Template File: sources-sink-72a.tmpl.java
*/
/*
 * @description
 * CWE: 789 Uncontrolled Memory Allocation
 * BadSource: max_value Set data to a hardcoded value of Integer.MAX_VALUE
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: ArrayList
 *    BadSink : Create an ArrayList using data as the initial size
 * Flow Variant: 72 Data flow: data passed in a Vector from one method to another in different source files in the same package
 *
 * */

package testcases.CWE789_Uncontrolled_Mem_Alloc.s02;
import testcasesupport.*;
import java.util.Vector;

import javax.servlet.http.*;

public class CWE789_Uncontrolled_Mem_Alloc__max_value_ArrayList_72a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int data;

        /* FLAW: Set data to Integer.MAX_VALUE */
        data = Integer.MAX_VALUE;

        Vector<Integer> dataVector = new Vector<Integer>(5);
        dataVector.add(0, data);
        dataVector.add(1, data);
        dataVector.add(2, data);
        (new CWE789_Uncontrolled_Mem_Alloc__max_value_ArrayList_72b()).badSink(dataVector  );
    }
}