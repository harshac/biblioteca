package com.twu28.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/15/12
 * Time: 10:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class LibraryMenu {
    private static List<String> listOfMenuOptions;
    private Console console=new Console();
    LibraryMenu()
    {
        listOfMenuOptions=new ArrayList<String>();
        listOfMenuOptions.add("1.View all books");
        listOfMenuOptions.add("2.Reserve a book");
        listOfMenuOptions.add("3.Check Library Number");
        listOfMenuOptions.add("4.View all movies");
        listOfMenuOptions.add("5.Exit");
    }


    public void displayMenu() {

        for(String item: listOfMenuOptions)
        {
            console.printToConsole(item);
        }
    }

    public int userMenuOptionIsInteger(String userMenuOptionFromConsole) throws IOException {
        int userMenuOption;
        try {
            userMenuOption = Integer.parseInt(userMenuOptionFromConsole);
        } catch (NumberFormatException numberFormatException) {
            return -1;
        }
        return userMenuOption;
    }

    public int getUserMenuOption() throws IOException {
        String userMenuOptionFromConsole=console.getInputFromConsole();
        int userMenuOption=userMenuOptionIsInteger(userMenuOptionFromConsole);
        if(!checkIfUserMenuOptionIsValid(userMenuOption))
        {
            userMenuOption=-1;
        }
        return userMenuOption;
    }

    public boolean checkIfUserMenuOptionIsValid(int userMenuOption) {
        int noOfMenuOptions=noOfMenuOptions();
        if(userMenuOption>=1 && userMenuOption<=noOfMenuOptions)
        {
            return true;
        }
        return false;
    }

    public int noOfMenuOptions()
    {
        return listOfMenuOptions.size();
    }
}
