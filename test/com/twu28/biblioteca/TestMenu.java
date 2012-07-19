package com.twu28.biblioteca;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/15/12
 * Time: 10:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestMenu {
    LibraryMenu libraryMenu=new LibraryMenu();


    @Test
    public void testDisplayMenu()
    {
        TestSpecificConsole testSpecificConsole =new TestSpecificConsole();
        testSpecificConsole.setUpOutputToPrintStream();
        String lineSeparator= testSpecificConsole.getLineSeparator();
        libraryMenu.displayMenu();
        String expectedListOfMenuOptions="1.View all books"+lineSeparator+"2.Reserve a book"+lineSeparator+"3.Check Library Number"+lineSeparator+"4.View all movies"+lineSeparator+"5.Exit"+lineSeparator;
        assertTrue(testSpecificConsole.getOutputStream().contains(expectedListOfMenuOptions));
        testSpecificConsole.tearDownOutputFromPrintStream();
    }

    @Test
    public void testIfUserMenuOptionIsInteger() throws IOException {

        assertEquals(13,libraryMenu.userMenuOptionIsInteger("13"));

    }

    @Test
    public void testIfUserMenuOptionIsValid()
    {
        boolean isValid=libraryMenu.checkIfUserMenuOptionIsValid(3);
        assertTrue(isValid);
    }

    @Test
    public void getUserMenuOption() throws IOException {
        TestSpecificConsole testSpecificConsole =new TestSpecificConsole("34");
        testSpecificConsole.setUpInputToByteArrayInputStream();
        int userMenuOption=libraryMenu.getUserMenuOption();
        assertEquals(-1,userMenuOption);
        testSpecificConsole.tearDownInputToSystemDotIn();
    }
}