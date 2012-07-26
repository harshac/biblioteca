package com.twu28.biblioteca;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/19/12
 * Time: 11:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestLoginCredentials {

    @Test
    public void testIfLibraryNumberIsIncrementedByOne()
    {
        User user=new User();
        Library library=new Library();
        user.addUser("Harsha","Chaudhary");
        LoginCredentials loginCredentials=new LoginCredentials(user,library.getUserListSize(),"abc");
        assertEquals(library.getUserListSize()+1111111,loginCredentials.getLibraryNumber());
    }

}
