package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/19/12
 * Time: 7:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class MovieRating {
    Movie movie;
    int rating;

    public MovieRating(Movie movie, int rating) {
        this.movie=movie;
        this.rating=rating;
    }

    public void assignRating(int rating) {
        this.rating=rating;
    }

    public int getRating() {
        return rating;
    }

    public String getMovieDetails() {
        String movieDetails=movie.getMovieDetails();
        if(rating>=0)
        {
            movieDetails=movieDetails.concat("\t"+rating);
        }
        else
        {
            movieDetails=movieDetails.concat("\tN/A");
        }
        return movieDetails;
    }
}
