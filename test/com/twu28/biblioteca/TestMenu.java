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
        TestConsole testConsole=new TestConsole();
        testConsole.setUpOutputToPrintStream();
        String lineSeparator=testConsole.getLineSeparator();
        libraryMenu.displayMenu();
        String expectedListOfMenuOptions="1.View all books"+lineSeparator+"2.Reserve a book"+lineSeparator+"3.Check Library Number"+lineSeparator+"4.Exit"+lineSeparator;
        assertEquals(expectedListOfMenuOptions, testConsole.getOutputStream());
    }

    @Test
    public void testIfUserMenuOptionIsInteger() throws IOException {

        assertTrue(libraryMenu.userMenuOptionIsInteger("13"));

    }

    @Test
    public void testIfUserMenuOptionIsValid()
    {
        boolean isValid=libraryMenu.checkIfUserMenuOptionIsValid(3);
        assertTrue(isValid);
    }

    @Test
    public void getUserMenuOption() throws IOException {
        TestConsole testConsole=new TestConsole("34");
        testConsole.setUpInputToByteArrayInputStream();
        int userMenuOption=libraryMenu.getUserMenuOption();
        assertEquals(34,userMenuOption);
        testConsole.tearDownInputToSystemDotIn();

    }

}