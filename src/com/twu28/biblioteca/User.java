package com.twu28.biblioteca;

import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/19/12
 * Time: 11:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private String firstName;
    private String lastName;

    public User()
    {
        this.firstName="";
        this.lastName="";
    }

    public boolean checkAllLetters(String stringToBeTested) {
        if(Pattern.matches("[a-zA-Z]+",stringToBeTested))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean addUser(String firstName, String lastName) {
        if(!checkAllLetters(firstName))
        {
            return false;
        }
        else
        {
            if(!checkAllLetters(lastName))
            {
                return false;
            }
        }
        return true;
    }
}
