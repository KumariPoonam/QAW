package com.qaworks.pageObjects;

import com.qaworks.Page;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {


    @FindBy(xpath = "//h3[contains(.,'Services')]")
    public WebElement header_Services;

    @FindBy(xpath = "//h3[contains(.,'Work')]")
    public WebElement header_Work;

    @FindBy(xpath = "//h3[contains(.,'Technology')]")
    public WebElement header_Technology;


    public boolean isHomePageElementsPresentAndDisplayed(WebElement element) {
        boolean isPresentAndDisplayed = false;

        try {
            moveToElement(element);
            waitForElementToBeVisible(element);
            isPresentAndDisplayed=isElementPresentAndDisplayed(element);
            logger.info("\nThe Home page element present and displayed status is : " + isPresentAndDisplayed + " .");
        } catch (NoSuchElementException nsee) {
            nsee.printStackTrace();
        }
        return isPresentAndDisplayed;
    }
}