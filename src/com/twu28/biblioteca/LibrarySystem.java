package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/15/12
 * Time: 5:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class LibrarySystem {

    private  OutputToConsole outputToConsole=new OutputToConsole();

    public void showWelcomeMessage() {
        outputToConsole.printToConsole("Welcome !!");
    }
}
