package com.twu28.biblioteca;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/13/12
 * Time: 12:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class LibraryTest extends TestCase {

    public void testBookAvailable() throws Exception {
        Library library=new Library();
        List<String> authors=new ArrayList<String>();
        authors.add("Barry Burd");
        Book book=new Book(267556,"Beginning Programming with Java For Dummies",authors,"Wiley");
        Books booksTemp=new Books(book,7);
        library.bookAvailable(booksTemp);
        assertEquals("Thank You! Enjoy the book","Thank You! Enjoy the book");
    }

    public void testBookUnavailable() throws Exception {
        Library library=new Library();
        List<String> authors=new ArrayList<String>();
        authors.add("Barry Burd");
        Book book=new Book(267556,"Beginning Programming with Java For Dummies",authors,"Wiley");
        Books booksTemp=new Books(book,7);
        library.bookAvailable(booksTemp);
        assertEquals("Sorry we don't have that book yet.","Sorry we don't have that book yet.");
    }

    public void testSearchBook() throws Exception {
        Library library=new Library();
        library.searchBook(122);
        assertEquals(-1,-1);

        library.searchBook(123345);
        assertEquals(0,0);
    }


}
