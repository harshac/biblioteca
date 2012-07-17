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
    private LibraryMenu libraryMenu=new LibraryMenu();

    public void showWelcomeMessage() {
        console.printToConsole("Welcome !!");
    }

    public void showMenu() {

        libraryMenu.displayMenu();
    }


    public int getMenuOption() throws IOException {

        return libraryMenu.getUserMenuOption();

    }

    public static void main(String args[]) throws IOException
    {
        LibrarySystem librarySystem=new LibrarySystem();
        Console consoleForMain=new Console();
        librarySystem.showWelcomeMessage();
        Library library=new Library();
        int choice=0;
        do{
            librarySystem.showMenu();
            consoleForMain.printToConsole("Enter Your Choice");
            choice=librarySystem.getMenuOption();
            switch (choice)
            {
                case 1:consoleForMain.printToConsole(library.viewAllBooks());
                    break;
                case 2: consoleForMain.printToConsole("Enter Book ISBN No: ");
                    int isbnNo=Integer.parseInt(consoleForMain.getInputFromConsole());
                    if(library.reserveBook(isbnNo))
                    {
                        consoleForMain.printToConsole("Thank You! Enjoy the book.");
                    }
                    else
                    {
                        consoleForMain.printToConsole("Sorry we don't have that book yet.");
                    }
                    break;
                case 3: consoleForMain.printToConsole("Please talk to Librarian. Thank you.");
                    break;
                case 4:
                    break;
                default:System.out.println("Select a valid option!!");
            }
        }while(choice!=4);


    }
}
