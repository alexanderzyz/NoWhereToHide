/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__int_zero_divide_73a.java
Label Definition File: CWE369_Divide_by_Zero__int.label.xml
Template File: sources-sinks-73a.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: zero Set data to a hardcoded value of zero
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: divide
 *    GoodSink: Check for zero before dividing
 *    BadSink : Dividing by a value that may be zero
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE369_Divide_by_Zero.s04;
import testcasesupport.*;
import java.util.LinkedList;

import javax.servlet.http.*;

public class CWE369_Divide_by_Zero__int_zero_divide_73a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int data;

        data = 0; /* POTENTIAL FLAW: data is set to zero */

        LinkedList<Integer> dataLinkedList = new LinkedList<Integer>();
        dataLinkedList.add(0, data);
        dataLinkedList.add(1, data);
        dataLinkedList.add(2, data);
        (new CWE369_Divide_by_Zero__int_zero_divide_73b()).badSink(dataLinkedList  );
    }
}