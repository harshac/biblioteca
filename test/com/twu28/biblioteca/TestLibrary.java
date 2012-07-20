package com.twu28.biblioteca;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/17/12
 * Time: 12:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestLibrary {

    Library library=new Library();

    @Test
    public void addBookOnlyIfIsbnNoIsDifferent()
    {
        List<String>authors=new ArrayList<String>();
        authors.add("Kent Beck");
        Book book=new Book(321146530, "Test Driven Development: By Example",authors,"Addison Wisley");
        BookInventory bookInventory=new BookInventory(book,3);
        int bookAddedSuccess;
        bookAddedSuccess = library.addBook(bookInventory);
        assertEquals(1,bookAddedSuccess);
    }

    @Test
    public void doNotAddBookIfIsbnNoIsSame()
    {
        List<String>authors=new ArrayList<String>();
        authors.add("Barry Burd");
        Book book=new Book(267556,"Beginning Programming with Java For Dummies",authors,"Wiley");
        BookInventory bookInventory=new BookInventory(book,7);
        int bookAddedSuccess;
        library.addBook(bookInventory);
        bookAddedSuccess=library.addBook(bookInventory);
        assertEquals(-1,bookAddedSuccess);
    }


    @Test
    public void testViewAllBooks()
    {
        String actual=library.viewAllBooks();
        String expected="321146530\tTest Driven Development: By Example\tKent Beck,\tAddison Wisley\t3\n267556\tBeginning Programming with Java For Dummies\tBarry Burd,\tWiley\t7\n";

        assertEquals(expected, actual);
    }

    @Test
    public void testIfBookListIsEmpty()
    {
        assertFalse(library.checkEmpty(library.getBookList()));
    }

    @Test
    public void testSearchBookWhenBookIsFound()
    {
        int bookPositionInList= library.searchBook(267556);
        assertEquals(1,bookPositionInList);
    }

    @Test
    public void testSearchBookWhenBookIsNotFound()
    {
        int bookPositionInList= library.searchBook(124345);
        assertEquals(-1,bookPositionInList);
    }

    @Test
    public void testIfBookIsAvailable()
    {
        List<String> authors=new ArrayList<String>();
        authors.add("Kathy Sierra");
        authors.add("Bert Bates");
        Book book=new Book(123345,"Head First Java",authors,"O'Reilly");
        BookInventory bookInventory= new BookInventory(book,1);
        assertTrue(library.checkBookAvailable(bookInventory));

    }

    @Test
    public void reserveBookIfAvailable()
    {
        assertTrue(library.reserveBook(267556));
    }

    @Test
    public void doNotReserveBookIfUnavailable()
    {
        List<String> authors=new ArrayList<String>();
        authors.add("Kathy Sierra");
        authors.add("Bert Bates");
        Book book=new Book(123385,"Head First Java",authors,"O'Reilly");
        BookInventory bookInventory= new BookInventory(book,0);
        assertFalse(library.reserveBook(123385));

    }


    @Test
    public void testIfMovieListIsEmpty()
    {
        List<String> directors=new ArrayList<String>();
        directors.add("Ramesh Sippy");
        Movie movie=new Movie("Sholay", directors);
        MovieRating movieRating=new MovieRating(movie,9);
        library.addMovie(movieRating);
        assertFalse(library.checkEmpty(library.getMovieList()));
    }

    @Test
    public void viewAllMovies()
    {
        List<String> directors=new ArrayList<String>();
        directors.add("Shakti Samanta");
        Movie movie=new Movie("Dushman", directors);
        MovieRating movieRating=new MovieRating(movie,-1);
        library.addMovie(movieRating);
        String expectedMovieDetails="1\tSholay\t--\tRamesh Sippy,\t--\t9\n2\tDushman\t--\tShakti Samanta,\t--\tN/A\n";
        assertEquals(expectedMovieDetails,library.viewAllMovies());
    }
}
