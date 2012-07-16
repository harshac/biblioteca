package com.twu28.biblioteca;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;


/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/15/12
 * Time: 5:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestLibrarySystem {
    private LibrarySystem librarySystem=new LibrarySystem();
    private TestConsole testConsole =new TestConsole();

    @Test
    public void showWelcomeMessageOnApplicationStart()
    {
        testConsole.setUpOutputToPrintStream();
        librarySystem.showWelcomeMessage();
        assertEquals("Welcome !!" + getLineSeparator(), getOutputStream() );
        testConsole.tearDownOutputFromPrintStream();
    }

    @Test
    public void showListOfMenuOptions()
    {
        testConsole.setUpOutputToPrintStream();
        librarySystem.showMenu();
        String lineSeparator=getLineSeparator();
        String expectedListOfMenuOptions="1.View all books"+lineSeparator+"2.Reserve a book"+lineSeparator+"3.Check Library Number"+lineSeparator+"4.Exit"+lineSeparator;
        assertEquals(expectedListOfMenuOptions, getOutputStream());
    }

    private String getLineSeparator()
    {
        return testConsole.getLineSeparator();
    }

    private String getOutputStream()
    {
        return testConsole.getOutputStream();
    }


}
