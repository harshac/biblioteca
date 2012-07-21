package com.twu28.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;



import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;


public class TestBook {

    Book book;

    @Before
    public void getBookInventoryObject()
    {
        List<String> authors=new ArrayList<String>();
        authors.add("Kathy Sierra");
        authors.add("Bert Bates");
        this.book=new Book(123345,"Head First Java",authors,"O'Reilly");
    }
    @Test
    public void testIfGetBookDetailsReturnsCorrectDetails()
    {
        String actualBookDetails;
        actualBookDetails=book.getBookDetails();
        assertEquals("123345\tHead First Java\tKathy Sierra,Bert Bates,\tO'Reilly",actualBookDetails);
    }

    @Test
    public void testIfGetAuthorsReturnsAllAuthorNames()
    {
        String actualAuthorNames;
        actualAuthorNames = book.getAuthors();
        assertEquals("\tKathy Sierra,Bert Bates,", actualAuthorNames);
    }

}
