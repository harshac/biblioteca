package com.twu28.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/15/12
 * Time: 5:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestConsole {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private ByteArrayInputStream inputStream;

    private String userInput="2";
    InputStream testInput;
    private Console console=new Console();

    public TestConsole() {
        inputStream = new ByteArrayInputStream(userInput.getBytes());
    }

    public TestConsole(String userInputToBeSet) {
        this.userInput=userInputToBeSet;
        inputStream = new ByteArrayInputStream(userInput.getBytes());
    }

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
        console.printToConsole("Welcome !!");
        assertEquals("Welcome !!" + lineSeparator,getOutputStream());
    }

    public String getLineSeparator()
    {
        return System.getProperty("line.separator");
    }

    public String getOutputStream()
    {
        return this.output.toString();
    }

    @Before
    public void setUpInputToByteArrayInputStream()
    {
        System.setIn(inputStream);

    }
    @Test
    public void testIfUserInputIsReceivedFromConsole() throws IOException {
        userInput=console.getInputFromConsole();
        assertEquals("2",userInput);

    }

    @After
    public void tearDownInputToSystemDotIn()
    {
        System.setIn(System.in);
    }

}
