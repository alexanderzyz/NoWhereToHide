package testcases.CWE36_Absolute_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

public class CWE36_Absolute_Path_Traversal__Property_67a extends AbstractTestCase {
    public void bad() throws Throwable
    {
        String data;

        /* get system property user.home */
        /* POTENTIAL FLAW: Read data from a system property */
        data = System.getProperty("user.home");

        Container dataContainer = new Container();
        dataContainer.containerOne = data;
        (new CWE36_Absolute_Path_Traversal__Property_67b()).badSink(dataContainer  );
    }
}