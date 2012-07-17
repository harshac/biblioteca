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
    private List<String> listOfMenuOptions=new ArrayList<String>();
    private int userMenuOption;
    private Console console=new Console();
    LibraryMenu()
    {
        listOfMenuOptions.add("1.View all books");
        listOfMenuOptions.add("2.Reserve a book");
        listOfMenuOptions.add("3.Check Library Number");
        listOfMenuOptions.add("4.Exit");
    }


    public void displayMenu() {

        for(String item: listOfMenuOptions)
        {
            console.printToConsole(item);
        }
    }

    public boolean userMenuOptionIsInteger(String userMenuOptionFromConsole) throws IOException {
        try
        {
            convertUserConsoleInputStringToInteger(userMenuOptionFromConsole);
        }
        catch (NumberFormatException numberFormatException)
        {
            return false;
        }
        return true;
    }

    public int getUserMenuOption() throws IOException {
        String userMenuOptionFromConsole=console.getInputFromConsole();
        userMenuOption=convertUserConsoleInputStringToInteger(userMenuOptionFromConsole);
        if(!userMenuOptionIsInteger(userMenuOptionFromConsole))
        {
            userMenuOption=-1;
        }
        if(!checkIfUserMenuOptionIsValid(this.userMenuOption))
        {
            userMenuOption=-1;
        }
        return userMenuOption;
    }

    public int convertUserConsoleInputStringToInteger(String userMenuOptionFromConsole)
    {
        userMenuOption=Integer.parseInt(userMenuOptionFromConsole);
        return userMenuOption;
    }


    public boolean checkIfUserMenuOptionIsValid(int userMenuOption) {
        if(userMenuOption>=1 && userMenuOption<=4)
        {
            return true;
        }
        return false;
    }
}
