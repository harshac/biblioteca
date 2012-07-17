package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/17/12
 * Time: 12:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class BookInventory {
    private Book book;
    private int noOfCopies;

    public BookInventory(Book bookToBeSet, int noOfCopies) {
        this.book=bookToBeSet;
        this.noOfCopies=noOfCopies;
    }

    public void setCopies() {
        if(this.noOfCopies>0)
        {
            noOfCopies=noOfCopies-1;
        }
    }

    public int getCopies() {
        return noOfCopies;
    }


    public String displayBookDetails() {
        String bookDetails= book.getBookDetails();
        bookDetails=bookDetails.concat("\t");
        bookDetails=bookDetails.concat(Integer.toString(noOfCopies));
        return bookDetails;
    }

    public Book getBook() {
        return this.book;
    }

    public boolean checkAvailable() {
        if(this.noOfCopies>0)
        {
            return true;
        }
        return false;
    }
}
