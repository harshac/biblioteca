package com.twu28.biblioteca;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/19/12
 * Time: 7:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Movie {
    private String name;
    private List<String> directors;

    public Movie()
    {
        this.name="abc";
        this.directors.add("xyz");
    }

    public Movie(String name, List<String> directors)
    {
        this.name=name;
        this.directors=directors;
    }

    public String getDirectors() {
        String directorNames="\t";
        for(String director:directors)
        {
            directorNames=directorNames.concat(director+",");
        }
        return directorNames;
    }

    public String getMovieDetails() {
        String movieDetails=this.name;
        movieDetails=movieDetails.concat("\t--" + getDirectors()+ "\t--");
        return movieDetails;
    }
}
