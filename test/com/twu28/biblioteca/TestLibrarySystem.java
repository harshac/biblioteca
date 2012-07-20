package com.twu28.biblioteca;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


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


    @Test
    public void testSearchUserWhenUserIsFound()
    {
        User user=new User();
        user.addUser("Celina","Bush");
        LoginCredentials loginCredentials=new LoginCredentials(user,librarySystem.getUserListSize(),"abc");
        librarySystem.addUserToLibrary(loginCredentials);

        user=new User();
        user.addUser("Justina","Mathew");
        loginCredentials=new LoginCredentials(user,librarySystem.getUserListSize(),"xyz");
        librarySystem.addUserToLibrary(loginCredentials);
        int userPositionInList= librarySystem.searchUser(1111112);
        assertEquals(1,userPositionInList);
    }

    @Test
    public void findUserInListWhenUserFound()
    {
        int index=librarySystem.findUserInList(1111112);
        assertEquals(1,index);
    }

    @Test
    public void findUserInListWhenUserNotFound()
    {
        int index=librarySystem.findUserInList(1111113);
        assertEquals(-1,index);
    }

    @Test
    public void testUserAuthenticationWhenSuccessful()
    {
        boolean authenticationSuccess= librarySystem.authenticateUser(1111111,"abc");
        assertTrue(authenticationSuccess);
    }

    @Test
    public void testUserAuthenticationWhenFailed()
    {
        boolean authenticationSuccess= librarySystem.authenticateUser(1111111,"ab");
        assertFalse(authenticationSuccess);
    }

    @Test
    public void testGetLibraryNumberWhenUserIsValid()
    {
        int found=librarySystem.searchUser(1111111);
        assertEquals(1111111,librarySystem.getLibraryNumber(librarySystem.getLoginCredentialsList().get(found)));

    }


}
