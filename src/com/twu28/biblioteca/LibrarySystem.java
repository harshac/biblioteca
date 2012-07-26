package com.twu28.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    private int loggedInUser=0;

    public void showWelcomeMessage() {
        console.printToConsole("Welcome !!");
    }

    public void setLoggedInUser(int loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void showMenu() {

        libraryMenu.displayMenu();
    }

    public int getLoggedInUser() {
        return loggedInUser;
    }

    public int noOfMenuOptions()
    {
        return libraryMenu.noOfMenuOptions();
    }


    public int getMenuOption() throws IOException {

        return libraryMenu.getUserMenuOption();

    }


    /*Static Blocks */

    public static void initialiseLibrary(Library library)
    {
        // Create author list
        List<String> authors=new ArrayList<String>();
        authors.add("Kathy Sierra");
        authors.add("Bert Bates");

        // Instantiate Book
        Book book=new Book(123345,"Head First Java",authors,"O'Reilly");

        //Instantiate BookInventory
        BookInventory booksTemp=new BookInventory(book,10);

        // Add book to list
        library.addBook(booksTemp);


        authors=new ArrayList<String>();
        authors.add("Barry Burd");
        book=new Book(267556,"Beginning Programming with Java For Dummies",authors,"Wiley");
        booksTemp=new BookInventory(book,7);
        library.addBook(booksTemp);

        authors=new ArrayList<String>();
        authors.add("Herbert Schildt");
        book=new Book(267589,"Java, A Beginner's Guide, 5th Edition",authors,"Oracle Press");
        booksTemp=new BookInventory(book,5);
        library.addBook(booksTemp);


        /* Movie 1*/
        List<String> directors=new ArrayList<String>();
        directors.add("Ramesh Sippy");
        Movie movie=new Movie("Sholay",directors);
        MovieRating movieRating=new MovieRating(movie,8);
        library.addMovie(movieRating);

        /* Movie 2*/
        directors=new ArrayList<String>();
        directors.add("Rajkumar Hirani");
        movie=new Movie("3 Idiots",directors);
        movieRating=new MovieRating(movie,9);
        library.addMovie(movieRating);

        /* Movie 3*/
        directors=new ArrayList<String>();
        directors.add("Homi Adajania");
        movie=new Movie("Cocktail",directors);
        movieRating=new MovieRating(movie,-1);
        library.addMovie(movieRating);

        /* Movie 4*/
        directors=new ArrayList<String>();
        directors.add("Anubhav Sinha");
        movie=new Movie("Ra One",directors);
        movieRating=new MovieRating(movie,4);
        library.addMovie(movieRating);

        /* Movie 5*/
        directors=new ArrayList<String>();
        directors.add("Karan Johar");
        movie=new Movie("My Name is Khan",directors);
        movieRating=new MovieRating(movie,8);
        library.addMovie(movieRating);

        /* Movie 6*/
        directors=new ArrayList<String>();
        directors.add("Mayur Puri");
        directors.add("Hema Malini");
        movie=new Movie("Tell Me O Kkhuda",directors);
        movieRating=new MovieRating(movie,2);
        library.addMovie(movieRating);

        /* Movie 7*/
        directors=new ArrayList<String>();
        directors.add("Hrishikesh Mukherjee");
        movie=new Movie("Anand",directors);
        movieRating=new MovieRating(movie,7);
        library.addMovie(movieRating);

        /* Movie 8*/
        directors=new ArrayList<String>();
        directors.add("Sajid Khan");
        movie=new Movie("Housefull 2",directors);
        movieRating=new MovieRating(movie,3);
        library.addMovie(movieRating);

        /* Movie 9*/
        directors=new ArrayList<String>();
        directors.add("Raj Kapoor");
        movie=new Movie("Mera Naam Joker",directors);
        movieRating=new MovieRating(movie,7);
        library.addMovie(movieRating);

        /* Movie 10*/
        directors=new ArrayList<String>();
        directors.add("Subhash Ghai");
        movie=new Movie("Hero",directors);
        movieRating=new MovieRating(movie,5);
        library.addMovie(movieRating);

        /* Movie 11*/
        directors=new ArrayList<String>();
        directors.add("Farhan Akhtar");
        movie=new Movie("Don 2",directors);
        movieRating=new MovieRating(movie,6);
        library.addMovie(movieRating);

        /* Movie 12*/
        directors=new ArrayList<String>();
        directors.add("A.R. Murugadoss");
        movie=new Movie("Ghajini",directors);
        movieRating=new MovieRating(movie,7);
        library.addMovie(movieRating);

        /* Movie 13*/
        directors=new ArrayList<String>();
        directors.add("Karan Malhotra");
        movie=new Movie("Agneepath",directors);
        movieRating=new MovieRating(movie,-1);
        library.addMovie(movieRating);

        /* Movie 14*/
        directors=new ArrayList<String>();
        directors.add("Anees Bazmee");
        movie=new Movie("Ready",directors);
        movieRating=new MovieRating(movie,5);
        library.addMovie(movieRating);

        /* Movie 15*/
        directors=new ArrayList<String>();
        directors.add("Prabhu Deva");
        movie=new Movie("Rowdy Rathore",directors);
        movieRating=new MovieRating(movie,-1);
        library.addMovie(movieRating);


        /*Users */
        User user=new User();
        user.addUser("Harsha","Chaudhary");
        LoginCredentials loginCredentials=new LoginCredentials(user, library.getUserListSize(),"abcd");
        library.addUserToLibrary(loginCredentials);

        user=new User();
        user.addUser("Amar", "Singh");
        loginCredentials=new LoginCredentials(user, library.getUserListSize(),"pqrs");
        library.addUserToLibrary(loginCredentials);

        user=new User();
        user.addUser("John","Mathew");
        loginCredentials=new LoginCredentials(user, library.getUserListSize(),"xyz");
        library.addUserToLibrary(loginCredentials);

        user=new User();
        user.addUser("Akanksha", "Kumar");
        loginCredentials=new LoginCredentials(user, library.getUserListSize(),"1234");
        library.addUserToLibrary(loginCredentials);
    }



    public static void main(String args[]) throws IOException
    {
        LibrarySystem librarySystem=new LibrarySystem();
        Console consoleForMain=new Console();
        librarySystem.showWelcomeMessage();
        Library library=new Library();
        int loginEnable=1;
        initialiseLibrary(library);
        int noOfMenuOptions=librarySystem.noOfMenuOptions();
        int choice=0;
        do{
            librarySystem.showMenu();
            consoleForMain.printToConsole("Enter Your Choice");
            choice=librarySystem.getMenuOption();
            switch (choice) {
                case 1:
                    consoleForMain.printToConsole(library.viewAllBooks());
                    break;
                case 2:
                    consoleForMain.printToConsole("Enter Book ISBN No: ");
                    int isbnNo = 0;
                    try {
                        isbnNo = Integer.parseInt(consoleForMain.getInputFromConsole());
                    } catch (NumberFormatException nfe) {
                        consoleForMain.printToConsole("Enter Valid ISBN No. !!");
                    }

                    if (library.reserveBook(isbnNo)) {
                        consoleForMain.printToConsole("Thank You! Enjoy the book.");
                    } else {
                        consoleForMain.printToConsole("Sorry we don't have that book yet.");
                    }
                    break;
                case 3:
                    int username=librarySystem.getLoggedInUser();
                    if(username!=0)
                    {
                        String libraryNumber="";
                        int usernameUpperPart=username/10000;
                        libraryNumber=libraryNumber.concat(Integer.toString(usernameUpperPart)+"-");
                        int usernameLowerPart=username%10000;
                        libraryNumber=libraryNumber.concat(Integer.toString(usernameLowerPart));
                        consoleForMain.printToConsole("Library Number :" + libraryNumber);
                    }
                    else
                    {
                        consoleForMain.printToConsole("Please talk to Librarian. Thank you.");
                    }
                    break;
                case 4:
                    consoleForMain.printToConsole(library.viewAllMovies());
                    break;
                case 5:
                    if(loginEnable==1)
                    {

                        consoleForMain.printToConsole("Username:");
                        String usernameString=consoleForMain.getInputFromConsole();
                        String usernameArray[]=usernameString.split("-");
                        username= Integer.parseInt(usernameArray[0])*10000;
                        String usernameLowerPart=usernameString.substring(4,8);
                        username=username+ Integer.parseInt(usernameLowerPart);
                        consoleForMain.printToConsole("Password");
                        String password=consoleForMain.getInputFromConsole();
                        if(library.authenticateUser(username,password))
                        {
                            consoleForMain.printToConsole("Successfully Logged in!!");
                            librarySystem.setLoggedInUser(username);
                            loginEnable=0;
                        }
                        else
                        {
                            consoleForMain.printToConsole("Login Failed!!");
                        }
                    }
                    else
                    {
                        consoleForMain.printToConsole("User already logged in!!");
                    }
                    break;
                case 6:
                    if(loginEnable!=1)
                    {
                        librarySystem.setLoggedInUser(0);
                        consoleForMain.printToConsole("Logged Out !!");
                        loginEnable=1;
                    }
                    else
                    {
                        consoleForMain.printToConsole("No User Logged in !!");
                    }
                    break;
                case 7: break;

                default:
                    System.out.println("Select a valid option!!");
            }
        }while(choice!=noOfMenuOptions);


    }





}
