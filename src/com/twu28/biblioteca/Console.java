package com.twu28.biblioteca;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/15/12
 * Time: 5:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Console {

    private String userInputFromConsole;
    private InputStream userInput;

    public void printToConsole(String textToBePrinted) {
        System.out.println(textToBePrinted);
    }

    public String getInputFromConsole() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        userInputFromConsole = br.readLine();
        return userInputFromConsole;
    }

   /* public String getPassword() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String password = br.readLine();
        char [] password=null;
        password=System.console().readPassword();
        return password.toString();
    }*/


}
