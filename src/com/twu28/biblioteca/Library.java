package com.twu28.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/17/12
 * Time: 12:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class Library {
    private static List<BookInventory> bookList=new ArrayList<BookInventory>();

    Library()
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
        addBook(booksTemp);


        authors=new ArrayList<String>();
        authors.add("Barry Burd");
        book=new Book(267556,"Beginning Programming with Java For Dummies",authors,"Wiley");
        booksTemp=new BookInventory(book,7);
        addBook(booksTemp);

        authors=new ArrayList<String>();
        authors.add("Herbert Schildt");
        book=new Book(267589,"Java, A Beginner's Guide, 5th Edition",authors,"Oracle Press");
        booksTemp=new BookInventory(book,5);
        addBook(booksTemp);
    }

    public int addBook(BookInventory book) {
        if(searchBook(book.getBook().getIsbnNo())==-1)
        {
            bookList.add(book);
        }
        else
        {
            return -1;
        }
        return 1;
    }

    public int searchBook(int bookNo)
    {
        int found=-1;
        if(!checkEmpty())
        {
            for(BookInventory book:bookList)
            {
                //Check if current book isbnNo == bookNo (to be searched)
                if(book.getBook().getIsbnNo()==bookNo)
                {
                    found=bookList.indexOf(book);
                    break;
                }
            }
        }
        return found;
    }

    public boolean checkEmpty() {
        return bookList.isEmpty();  //To change body of created methods use File | Settings | File Templates.
    }

    public String viewAllBooks() {
        String allBookDetails="";
        for(BookInventory bookTemp:bookList)
        {
            allBookDetails=allBookDetails.concat(bookTemp.displayBookDetails()+"\n");
        }
        return allBookDetails;
    }


    public boolean checkBookAvailable(BookInventory bookInventory) {
        return  bookInventory.checkAvailable();
    }

    public boolean reserveBook(int bookIsbnNoToBeReserved) {
        int found=-1;
        found=searchBook(bookIsbnNoToBeReserved);
        if(found!=-1)       // Book is found
        {
            BookInventory book=bookList.get(found);
            if(checkBookAvailable(book))
            {
                book.setCopies();
            }
            else
            {
                return false;
            }
        }
        else               // Book not found
        {
            return false;
        }
        return true;
    }
}
