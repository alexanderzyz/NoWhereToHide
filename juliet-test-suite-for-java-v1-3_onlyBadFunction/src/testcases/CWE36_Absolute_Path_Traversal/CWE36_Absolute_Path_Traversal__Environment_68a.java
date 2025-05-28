package testcases.CWE36_Absolute_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

public class CWE36_Absolute_Path_Traversal__Environment_68a extends AbstractTestCase {
    public void bad() throws Throwable
    {

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read data from an environment variable */
        data = System.getenv("ADD");

        (new CWE36_Absolute_Path_Traversal__Environment_68b()).badSink();
    }
}