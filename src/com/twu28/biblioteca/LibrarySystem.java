package com.twu28.biblioteca;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;



/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/12/12
 * Time: 8:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class LibrarySystem
{
    /** Main method
     *
     * @param args
     * @throws IOException
     */
    public static void main(String args[])throws IOException
    {
      int choice=0;
      Library library=new Library();
      printWelcome();
        do{
            printMenu();
            choice=getInput();
            switch (choice)
            {
                case 1:library.viewBooks();
                    break;
                case 2: System.out.println("Enter Book ISBN No: ");
                    int isbnNo=getInput();
                    library.reserveBook(isbnNo);
                    break;
                case 3: System.out.println("Please talk to Librarian. Thank you.");
                    break;
                case 4:
                        break;
                default:System.out.println("Select a valid option!!");
            }
        }while(choice!=4);

    }

    /** Prints Menu
     *
     */
    public static void printMenu()
    {
        System.out.println();
        System.out.println("*** Menu ***");
        System.out.println("1. View all books");
        System.out.println("2. Reserve book");
        System.out.println("3. Check Library Number");
        System.out.println("4. Quit");
        System.out.print("Enter your choice: ");
      }

    /** Takes user input
     *
     * @return
     * @throws IOException
     */
    public static int getInput() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ch=br.readLine();

        //Convert String to integer
        int choice=Integer.parseInt(ch);
        System.out.println();
        return choice;
    }

    /** Prints welcome message
     *
     */
    public static void printWelcome()
    {
        System.out.println("Welcome to Library!!");
        System.out.println();
    }

}
