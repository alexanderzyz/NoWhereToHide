package testcases.CWE36_Absolute_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

public class CWE36_Absolute_Path_Traversal__Environment_67a extends AbstractTestCase {
    public void bad() throws Throwable
    {
        String data;

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read data from an environment variable */
        data = System.getenv("ADD");

        Container dataContainer = new Container();
        dataContainer.containerOne = data;
        (new CWE36_Absolute_Path_Traversal__Environment_67b()).badSink(dataContainer  );
    }
}