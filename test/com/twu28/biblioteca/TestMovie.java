package com.twu28.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/19/12
 * Time: 7:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestMovie {

    @Test
    public void testGetDirectorName()
    {
        List<String> directors=new ArrayList<String>();
        directors.add("Mayur Puri");
        directors.add("Hema Malini");
        Movie movie=new Movie("Tell Me O Kkhuda",directors);
        String directorNames=movie.getDirectors();
        assertEquals("\tMayur Puri,Hema Malini,",directorNames);
    }

    @Test
    public void testGetMovieDetails()
    {
        List<String> directors=new ArrayList<String>();
        directors.add("Mayur Puri");
        directors.add("Hema Malini");
        Movie movie=new Movie("Tell Me O Kkhuda",directors);
        String movieDetails=movie.getMovieDetails();
        assertEquals("Tell Me O Kkhuda\t--\tMayur Puri,Hema Malini,\t--",movieDetails);
    }
}
