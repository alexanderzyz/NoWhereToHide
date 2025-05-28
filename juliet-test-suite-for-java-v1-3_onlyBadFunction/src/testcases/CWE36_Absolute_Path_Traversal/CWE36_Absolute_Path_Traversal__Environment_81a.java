package testcases.CWE36_Absolute_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

public class CWE36_Absolute_Path_Traversal__Environment_81a extends AbstractTestCase {
    public void bad() throws Throwable
    {
        String data;

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read data from an environment variable */
        data = System.getenv("ADD");

        CWE36_Absolute_Path_Traversal__Environment_81_base baseObject = new CWE36_Absolute_Path_Traversal__Environment_81_bad();
        baseObject.action(data );
    }
}