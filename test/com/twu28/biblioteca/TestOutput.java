package com.twu28.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/15/12
 * Time: 5:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestOutput {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUpOutputToPrintStream()
    {
        System.setOut(new PrintStream(this.output));
    }

    @After
    public  void tearDownOutputFromPrintStream()
    {
        System.setOut(null);
    }

    @Test
    public void testIfMessageIsPrintedToConsole()
    {
        String lineSeparator=getLineSeparator();
        OutputToConsole outputToConsole=new OutputToConsole();
        outputToConsole.printToConsole("Welcome !!");
        assertEquals("Welcome !!" + lineSeparator,output.toString());
    }

    public String getLineSeparator()
    {
        return System.getProperty("line.separator");
    }

    public String getOutputStream()
    {
        return this.output.toString();
    }

}
