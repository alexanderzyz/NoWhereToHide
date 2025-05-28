package testcases.CWE36_Absolute_Path_Traversal;

import testcasesupport.*;
import java.util.Vector;

import java.io.*;
import javax.servlet.http.*;

public class CWE36_Absolute_Path_Traversal__Property_72a extends AbstractTestCase {
    public void bad() throws Throwable
    {
        String data;

        /* get system property user.home */
        /* POTENTIAL FLAW: Read data from a system property */
        data = System.getProperty("user.home");

        Vector<String> dataVector = new Vector<String>(5);
        dataVector.add(0, data);
        dataVector.add(1, data);
        dataVector.add(2, data);
        (new CWE36_Absolute_Path_Traversal__Property_72b()).badSink(dataVector  );
    }
}