package com.twu28.biblioteca;

import java.util.ArrayList;
import java.util.Collection;
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
    private static List<MovieRating> movieList=new ArrayList<MovieRating>();

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
        if(!checkEmpty(this.getBookList()))
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

    public boolean checkEmpty(Collection list) {
        return list.isEmpty();  //To change body of created methods use File | Settings | File Templates.
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

    public List<BookInventory> getBookList()
    {
        return bookList;
    }

    public List<MovieRating> getMovieList() {
        return movieList;
    }

    public void addMovie(MovieRating movieRating) {
        movieList.add(movieRating);
    }

    public String viewAllMovies() {
        int i=1;
        String movieDetails="";
        for(MovieRating movie: movieList)
        {
            movieDetails=movieDetails.concat(Integer.toString(i)+"\t");
            movieDetails=movieDetails.concat(movie.getMovieDetails()+"\n");
            i++;
        }
        return  movieDetails;
    }
}
