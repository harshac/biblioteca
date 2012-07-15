package com.twu28.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 7/15/12
 * Time: 5:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestLibrarySystem {

    @Test
    public void showWelcomeMessageOnApplicationStart()
    {
        LibrarySystem librarySystem=new LibrarySystem();
        TestOutput testOutput=new TestOutput();
        testOutput.setUpOutputToPrintStream();
        librarySystem.showWelcomeMessage();
        assertEquals("Welcome !!" + testOutput.getLineSeparator(), testOutput.getOutputStream());
    }


}
