package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/12/12
 * Time: 8:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Books {
    private Book book;
    private int copies;


    /** Default Constructor
     *
      */
    Books()
    {
        book=null;
        copies=0;

    }

    /** Parametrised Constructor
     *
     * @param book
     * @param copies
     */
    Books(Book book, int copies)
    {
        this.book=book;
        this.copies=copies;
    }

    /** Setter copies
     *
     */
    public void setCopies()
    {
        if(this.copies>0)
        {
            this.copies--;
        }

    }

    /** Getter copies
     *
     * @return
     */
    public int getCopies()
    {
        return this.copies;
    }

    /** Getter book
     *
     * @return
     */
    public Book getBook() {
        return book;
    }
}
