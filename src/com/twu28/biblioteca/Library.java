package com.twu28.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/12/12
 * Time: 8:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class Library {
    private static List<Books> books=new ArrayList<Books>();

    /** Default Constructor
     *
     */
    Library()
    {
        // Create author list
        List<String> authors=new ArrayList<String>();
        authors.add("Kathy Sierra");
        authors.add("Bert Bates");

        // Instantiate Book
        Book book=new Book(123345,"Head First Java",authors,"O'Reilly");

        //Instantiate Books
        Books booksTemp=new Books(book,10);

        // Add book to list
        addBook(booksTemp);


        authors=new ArrayList<String>();
        authors.add("Barry Burd");
        book=new Book(267556,"Beginning Programming with Java For Dummies",authors,"Wiley");
        booksTemp=new Books(book,7);
        addBook(booksTemp);

        authors=new ArrayList<String>();
        authors.add(" Herbert Schildt");
        book=new Book(267589,"Java, A Beginner's Guide, 5th Edition",authors,"Oracle Press");
        booksTemp=new Books(book,5);
        addBook(booksTemp);


    }

    /** Adds book to list
     *
     * @param book
     */
    public void addBook(Books book)
    {
        books.add(book);
    }

    /** Reserves book
     *
     * @param bookNo
     */
    public void reserveBook(int bookNo)
    {
        int found=-1;
        found=searchBook(bookNo);
        if(found!=-1)       // Book is found
        {
            Books book=books.get(found);
            checkAvailable(book);
        }
        else               // Book not found
        {
            bookUnavailable();
        }
    }

    /** Checks if book is available
     *
     * @param book
     */
    public void checkAvailable(Books book)
    {
        if(book.getCopies()>0)           // Checks if copies are available
        {
            bookAvailable(book);
        }
        else
        {
            bookUnavailable();
        }
    }

    /** Prints message if book unavailable
     *
     */
    public void bookUnavailable()
    {
        System.out.println("Sorry we don't have that book yet.");
    }

    /** Reduces available count and prints message
     *
     * @param book
     */
    public  void bookAvailable(Books book)
    {
        book.setCopies();
        System.out.println("Thank You! Enjoy the book");
    }

    /** Searches if a book is present
     *
     * @param bookNo
     * @return
     */
    public int searchBook(int bookNo)
    {
        int found=-1;
        if(!checkEmpty())
        {
            for(Books book:books)
            {
                //Check if current book isbnNo == bookNo (to be searched)
                if(book.getBook().getIsbnNo()==bookNo)
                {
                    found=books.indexOf(book);
                    break;
                }
            }
        }
        return found;
    }

    /** Views all books
     *
     */
    public void viewBooks()
    {
        if(!checkEmpty())
        {
            printBooks();
        }
    }

    /** Prints all book details
     *
     */
    public void printBooks()
    {
        System.out.println("ISBN No" + "\t" + "Title" +"\t" + "No. of Copies Available");
        for( Books book : books)
        {
            Book bookDetail=book.getBook();
            System.out.println(bookDetail.getIsbnNo() + "\t" + bookDetail.getTitle() +"\t" + book.getCopies());

        }
        System.out.println();
    }

    /** Checks if list is empty
     *
     * @return
     */
    public boolean checkEmpty()
    {
        return books.isEmpty();
    }



    /**
     * Created with IntelliJ IDEA.
     * User: hp
     * Date: 7/12/12
     * Time: 8:12 PM
     * To change this template use File | Settings | File Templates.
     */

}
