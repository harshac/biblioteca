package com.twu28.biblioteca;

import org.junit.Test;
import org.w3c.dom.UserDataHandler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/19/12
 * Time: 10:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestUser {

    @Test
    public void testIfNameContainsAllLetter()
    {
        User user=new User();
        assertTrue(user.checkAllLetters("abc"));
    }

    @Test
    public void testIfNameContainsNumber()
    {
        User user=new User();
        assertFalse(user.checkAllLetters("abc123"));
    }

    @Test
    public void testIfNameContainsSpecialCharacter()
    {
        User user=new User();
        assertFalse(user.checkAllLetters("abc123@"));
    }

    @Test
    public void addUserIfNamesAreValid()
    {
        User user=new User();
        assertFalse(user.addUser("Harsha","Chaudhary12"));
    }
}
