package com.twu28.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/17/12
 * Time: 12:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestBookInventory {

    BookInventory bookInventory;

    @Before
    public void getBookInventoryObject()
    {
        List<String> authors=new ArrayList<String>();
        authors.add("Kathy Sierra");
        authors.add("Bert Bates");
        Book book=new Book(123345,"Head First Java",authors,"O'Reilly");
        this.bookInventory= new BookInventory(book,5);

    }

    @Test
    public void testSetCopies()
    {
        bookInventory.setCopies();
        assertEquals(4,bookInventory.getCopies());
    }

    @Test
    public void testDisplayBookDetails()
    {
        getBookInventoryObject();
        String actualBookDetails;
        actualBookDetails = bookInventory.displayBookDetails();
        TestSpecificConsole testSpecificConsole =new TestSpecificConsole();
        assertEquals("123345\tHead First Java\tKathy Sierra,Bert Bates,\tO'Reilly\t5",actualBookDetails);
    }

    @Test
    public void testBookIsAvailableIfNoOfCopiesIsGreaterThanZero()
    {
        assertTrue(bookInventory.checkAvailable());
    }

    @Test
    public void testBookNotAvailableIfNoOfCopiesIsEqualToZero()
    {
        List<String> authors=new ArrayList<String>();
        authors.add("Kathy Sierra");
        authors.add("Bert Bates");
        Book book=new Book(123345,"Head First Java",authors,"O'Reilly");
        BookInventory bookInventory1= new BookInventory(book,0);
        assertFalse(bookInventory1.checkAvailable());

    }

}
