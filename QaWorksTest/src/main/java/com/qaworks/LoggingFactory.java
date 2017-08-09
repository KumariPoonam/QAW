package com.qaworks;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggingFactory {


    static final Logger logger = Logger.getLogger("Poonam Kumari");

    public static Logger getLogger(){
        PropertyConfigurator.configure("log4j.properties");
        return logger ;
    }
}
