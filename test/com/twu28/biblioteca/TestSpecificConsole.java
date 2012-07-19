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
public class TestSpecificConsole {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private ByteArrayInputStream inputStream;

    public TestSpecificConsole() {

        inputStream = new ByteArrayInputStream("".getBytes());
    }



    public TestSpecificConsole(String userInput) {
        inputStream = new ByteArrayInputStream(userInput.getBytes());
    }


    public String getLineSeparator()
    {
        return System.getProperty("line.separator");
    }

    public String getOutputStream()
    {
        return this.output.toString();
    }


    public void setUpOutputToPrintStream()
    {
        System.setOut(new PrintStream(this.output));
    }


    public  void tearDownOutputFromPrintStream()
    {
        System.setOut(null);
    }


    public void setUpInputToByteArrayInputStream()
    {
        System.setIn(inputStream);

    }


    public void tearDownInputToSystemDotIn()
    {
        System.setIn(System.in);
    }

}
