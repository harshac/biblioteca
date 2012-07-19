package com.twu28.biblioteca;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;


/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/15/12
 * Time: 5:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestLibrarySystem {
    private LibrarySystem librarySystem=new LibrarySystem();
    private TestSpecificConsole testSpecificConsole =new TestSpecificConsole();

    @Test
    public void showWelcomeMessageOnApplicationStart()
    {
        testSpecificConsole.setUpOutputToPrintStream();
        librarySystem.showWelcomeMessage();
        assertEquals("Welcome !!" + getLineSeparator(), getOutputStream() );
        testSpecificConsole.tearDownOutputFromPrintStream();
    }

    @Test
    public void showListOfMenuOptions()
    {
        testSpecificConsole.setUpOutputToPrintStream();
        librarySystem.showMenu();
        String lineSeparator=getLineSeparator();
        String expectedListOfMenuOptions="1.View all books"+lineSeparator+"2.Reserve a book"+lineSeparator+"3.Check Library Number"+lineSeparator+"4.View all movies"+lineSeparator+"5.Exit"+lineSeparator;
        assertTrue(getOutputStream().contains(expectedListOfMenuOptions));

    }

    private String getLineSeparator()
    {
        return testSpecificConsole.getLineSeparator();
    }

    private String getOutputStream()
    {
        return testSpecificConsole.getOutputStream();
    }

    @Test
    public void getValidMenuOptionFromCustomer() throws IOException {
        TestSpecificConsole testSpecificConsole =new TestSpecificConsole("4");
        testSpecificConsole.setUpInputToByteArrayInputStream();
        int userMenuOption=librarySystem.getMenuOption();
        assertEquals(4,userMenuOption);
        testSpecificConsole.tearDownInputToSystemDotIn();
    }

    @Test
    public void getInvalidMenuOptionFromCustomerWhenUserInput() throws IOException {
        TestSpecificConsole testSpecificConsole =new TestSpecificConsole("34");
        testSpecificConsole.setUpInputToByteArrayInputStream();
        int userMenuOption=librarySystem.getMenuOption();
        assertEquals(-1,userMenuOption);
        testSpecificConsole.tearDownInputToSystemDotIn();
    }



}
