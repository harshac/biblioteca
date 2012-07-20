package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/19/12
 * Time: 11:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginCredentials {
    private User user;
    private int libraryNumber;
    private String password;

    public LoginCredentials(User user,int libraryNumber, String password)
    {
        this.user=user;
        this.libraryNumber=createLibraryNo(libraryNumber);
        this.password=password;
    }

    public int getLibraryNumber() {
        return libraryNumber;
    }

    public int createLibraryNo(int libraryNumber) {
        return libraryNumber+1111111;
    }

    public String getPassword()
    {
        return password;
    }
}
