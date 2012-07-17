package com.twu28.biblioteca;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/17/12
 * Time: 12:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class Book {
    private int isbnNo;
    private String title;
    private List<String> authors;
    private String publication;

    public Book()
    {
        this.isbnNo=0;
        this.title="abc";
        authors.add("abc");
        this.publication="abc";
    }

    public Book(int isbnNoToBeSet, String titleToBeSet, List<String> authorsToBeSet, String publicationToBeSet) {
        this.isbnNo=isbnNoToBeSet;
        this.title=titleToBeSet;
        this.authors=authorsToBeSet;
        this.publication=publicationToBeSet;
    }

    public String getBookDetails() {
        String bookDetails;
        bookDetails=Integer.toString(isbnNo);
        bookDetails=bookDetails.concat("\t" + title);
        bookDetails=bookDetails.concat(getAuthors());
        bookDetails=bookDetails.concat("\t" + publication);
        return bookDetails;
    }

    public String getAuthors() {
        String authorNames="\t";
        for(String author:authors)
        {
            authorNames=authorNames.concat(author+ ",");

        }
        return authorNames;
    }


    public int getIsbnNo() {
        return isbnNo;
    }
}
