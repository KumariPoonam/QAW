package com.qaworks;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BrowserFactory extends LoggingFactory {

    private static WebDriver driver ;
    private static  String url;
    private static String browser;
    static Logger logger = LoggingFactory.getLogger();


    public BrowserFactory(){
        PageFactory.initElements(driver, this);
    }

    public static void openBrowser() throws IOException, InterruptedException {

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/config.properties");
        properties.load(fileInputStream);
        url = properties.getProperty("url");
        browser = properties.getProperty("browser");


        if (browser.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver" , (System.getProperty("user.dir")+"/src/test/java/com/qaworks/chromedriver"));
            driver = new ChromeDriver();
            logger.info("\nOpening Chrome Browser");
        }

        else if(browser.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        }
        driver.get(url);
        Dimension d = new Dimension(1680,1050);
        driver.manage().window().setSize(d);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
    }

    public static void closeBrowser(){
        driver.close();
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
