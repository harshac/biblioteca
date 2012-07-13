package com.twu28.biblioteca;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/12/12
 * Time: 6:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class Book {
    private int isbnNo;
    private   String title;
    private  List<String> authors;
    private  String publication;

    // Default Constructor
    Book()
    {
        isbnNo=0;
        title="abc";
        authors.add("abc");
        publication="abc";
    }

    /** Parametrised Constructor
     *
     * @param isbnNo
     * @param title
     * @param authors
     * @param publication
     */
    Book(int isbnNo, String title, List<String> authors, String publication)
    {
        this.isbnNo=isbnNo;
        this.title=title;
        this.authors=authors;
        this.publication=publication;
    }

    /** Getter isbnNo
     *
     * @return
     */
    public int getIsbnNo() {
        return isbnNo;
    }

    /** Getter title
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /** Getter authors
     *
     * @return
     */
    public List<String> getAuthors() {
        return authors;
    }

    /** Getter publication
     *
     * @return
     */
    public String getPublication() {
        return publication;
    }


}
