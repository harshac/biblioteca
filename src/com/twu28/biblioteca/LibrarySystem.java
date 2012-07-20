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
    private static List<LoginCredentials> loginCredentialsList=new ArrayList<LoginCredentials>();

    public void showWelcomeMessage() {
        console.printToConsole("Welcome !!");
    }

    public void showMenu() {

        libraryMenu.displayMenu();
    }

    public int noOfMenuOptions()
    {
        return libraryMenu.noOfMenuOptions();
    }


    public int getMenuOption() throws IOException {

        return libraryMenu.getUserMenuOption();

    }

    public int getUserListSize() {
        return loginCredentialsList.size();
    }

    public void addUserToLibrary(LoginCredentials loginCredentials)
    {
        loginCredentialsList.add(loginCredentials);
    }


    public int searchUser(int libraryNumber) {
        int found=-1;
        if(!checkEmpty(loginCredentialsList))
        {
            found=findUserInList(libraryNumber);
        }
        return found;
    }

    public boolean checkEmpty(Collection list) {
        return list.isEmpty();  //To change body of created methods use File | Settings | File Templates.
    }

    public int findUserInList(int libraryNumber) {
        int found = -1;
        for (LoginCredentials loginCredentials : loginCredentialsList) {
            if (loginCredentials.getLibraryNumber() == libraryNumber)
            {
                found = loginCredentialsList.indexOf(loginCredentials);
                break;
            }
        }
        return found;
    }

    public boolean authenticateUser(int libraryNumber, String password) {
        int found=searchUser(libraryNumber);
        if(found!=-1)
        {
            return verifyPassword(found,password);
        }
        else
        {
            return false;
        }
    }


    private boolean verifyPassword(int libraryNumberIndex, String password) {
        LoginCredentials loginCredentials=loginCredentialsList.get(libraryNumberIndex);
        if(loginCredentials.getPassword().equals(password))
        {
            return true;
        }
        return false;
    }

    public List<LoginCredentials> getLoginCredentialsList() {
        return loginCredentialsList;
    }

    public int getLibraryNumber(LoginCredentials loginCredentials){
        return loginCredentials.getLibraryNumber();
    }

    /*Static Blocks */

    public static void addBooks(Library library)
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
    }

        public static void addMovies(Library library)
    {
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
    }

    public static void addUsers(LibrarySystem librarySystem)
    {
        User user=new User();
        user.addUser("Harsha","Chaudhary");
        LoginCredentials loginCredentials=new LoginCredentials(user, librarySystem.getUserListSize(),"abcd");
        librarySystem.addUserToLibrary(loginCredentials);

        user=new User();
        user.addUser("Amar","Singh");
        loginCredentials=new LoginCredentials(user, librarySystem.getUserListSize(),"pqrs");
        librarySystem.addUserToLibrary(loginCredentials);

        user=new User();
        user.addUser("John","Mathew");
        loginCredentials=new LoginCredentials(user, librarySystem.getUserListSize(),"xyz");
        librarySystem.addUserToLibrary(loginCredentials);

        user=new User();
        user.addUser("Akanksha", "Kumar");
        loginCredentials=new LoginCredentials(user, librarySystem.getUserListSize(),"1234");
        librarySystem.addUserToLibrary(loginCredentials);
    }



    public static void main(String args[]) throws IOException
    {
        LibrarySystem librarySystem=new LibrarySystem();
        Console consoleForMain=new Console();
        librarySystem.showWelcomeMessage();
        Library library=new Library();
        addBooks(library);
        addMovies(library);
        addUsers(librarySystem);
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
                    consoleForMain.printToConsole("Username:");
                    int username= 0;
                    username= Integer.parseInt(consoleForMain.getInputFromConsole());
                    consoleForMain.printToConsole("Password");
                    String password=consoleForMain.getInputFromConsole();
                    if(librarySystem.authenticateUser(username,password))
                    {
                        int found=librarySystem.searchUser(username);
                        String libraryNumber= Integer.toString(librarySystem.getLibraryNumber(librarySystem.getLoginCredentialsList().get(found)));
                        consoleForMain.printToConsole("Libary Number :" + libraryNumber);
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
                    break;
                default:
                    System.out.println("Select a valid option!!");
            }
        }while(choice!=noOfMenuOptions);


    }





}
