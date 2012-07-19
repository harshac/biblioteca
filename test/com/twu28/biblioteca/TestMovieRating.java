package com.twu28.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/19/12
 * Time: 6:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestMovieRating {

    @Test
    public void testAssignMovieRating()
    {
        List<String> directors=new ArrayList<String>();
        directors.add("Ramesh Sippy");
        Movie movie=new Movie("Sholay", directors);
        MovieRating movieRating=new MovieRating(movie,-1);
        int rating=5;
        movieRating.assignRating(rating);
        assertEquals(movieRating.getRating(),rating);
    }

    @Test
    public void testGetMovieDetails()
    {
        List<String> directors=new ArrayList<String>();
        directors.add("Ramesh Sippy");
        Movie movie=new Movie("Sholay", directors);
        MovieRating movieRating=new MovieRating(movie,9);
        String expectedMovieDetails="Sholay\tRamesh Sippy,\t9";
        assertEquals(expectedMovieDetails,movieRating.getMovieDetails());
    }

    @Test
    public void testGetMovieDetailsWhenRatingNotApplicable()
    {
        List<String> directors=new ArrayList<String>();
        directors.add("Homi Adajania");
        Movie movie=new Movie("Cocktail", directors);
        MovieRating movieRating=new MovieRating(movie,-1);
        String expectedMovieDetails="Cocktail\tHomi Adajania,\tN/A";
        assertEquals(expectedMovieDetails,movieRating.getMovieDetails());
    }

}
