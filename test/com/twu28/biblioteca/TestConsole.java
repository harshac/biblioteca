package com.twu28.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/17/12
 * Time: 3:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestConsole {


    private Console console=new Console();

    @Test
    public void testIfMessageIsPrintedToConsole()
    {
        TestSpecificConsole testSpecificConsole =new TestSpecificConsole("2");
        testSpecificConsole.setUpOutputToPrintStream();
        String lineSeparator= testSpecificConsole.getLineSeparator();
        console.printToConsole("Welcome !!");
        assertEquals("Welcome !!" + lineSeparator,testSpecificConsole.getOutputStream());
        testSpecificConsole.tearDownInputToSystemDotIn();
    }

    @Test
    public void testIfUserInputIsReceivedFromConsole() throws IOException {
        TestSpecificConsole testSpecificConsole =new TestSpecificConsole("2");
        testSpecificConsole.setUpInputToByteArrayInputStream();
        String userInput = console.getInputFromConsole();
        assertEquals("2",userInput);
        testSpecificConsole.tearDownInputToSystemDotIn();
    }




}
