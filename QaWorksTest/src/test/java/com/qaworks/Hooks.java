package com.qaworks;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;

public class Hooks {


    public void welcomeMessage(){
        System.out.println("Welcome to My Framework\n" +
                "Hope you like this effort by Poonam Kumari\n" +
                "THANK YOU");
    }

    public void goodBye(){
        System.out.println("Thanking you for your time in milliseconds . LOL\n");
    }

    @Before

    public void setup() throws IOException, InterruptedException {
        welcomeMessage();
        BrowserFactory.openBrowser();

    }

    @After

    public void tearDown(){
        goodBye();
        BrowserFactory.closeBrowser();
    }
}
