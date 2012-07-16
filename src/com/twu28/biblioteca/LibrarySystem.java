package com.twu28.biblioteca;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/15/12
 * Time: 5:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class LibrarySystem {

    private Console console =new Console();

    public void showWelcomeMessage() {
        console.printToConsole("Welcome !!");
    }

    public void showMenu() {
       LibraryMenu libraryMenu=new LibraryMenu();
        libraryMenu.displayMenu();
    }


}
