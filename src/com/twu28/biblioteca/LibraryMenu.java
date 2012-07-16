package com.twu28.biblioteca;

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

    LibraryMenu()
    {
        listOfMenuOptions.add("1.View all books");
        listOfMenuOptions.add("2.Reserve a book");
        listOfMenuOptions.add("3.Check Library Number");
        listOfMenuOptions.add("4.Exit");
    }


    public void displayMenu() {
        Console console=new Console();
        for(String item: listOfMenuOptions)
        {
            console.printToConsole(item);
        }
    }
}
