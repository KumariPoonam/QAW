package com.qaworks.pageObjects;

import com.qaworks.Page;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationPanel extends Page {


    @FindBy(xpath = "//a[contains(.,'Home')]")
    public WebElement homeTab;

    @FindBy(xpath = "//a[contains(.,'Services')]")
    public WebElement servicesTab;

    @FindBy(xpath = "//a[contains(.,'Work')]")
    public WebElement workTab;

    @FindBy(xpath = "//a[contains(.,'Technology')]")
    public WebElement technologyTab;

    @FindBy(xpath = "//a[contains(.,'Prices')]")
    public WebElement pricesTab;

    @FindBy(xpath = "//a[contains(.,'News')]")
    public WebElement newsTab;

    @FindBy(xpath = "//a[contains(.,'About')]")
    public WebElement aboutTab;

    @FindBy(xpath = "//a[contains(.,'Careers')]")
    public WebElement careersTab;

    @FindBy(xpath = "//a[contains(.,'Contact')]")
    public WebElement contactTab;


    public boolean isTabMenuOprionPresentAndDisplayed(WebElement element){
        boolean isPresentAndDisplayed= false;

        try{
            isElementPresentAndDisplayed(element);
            logger.info("\nThe Navigation Panel present and displayed status is : "+isPresentAndDisplayed+" .");
        }catch (NoSuchElementException nsee){
            nsee.printStackTrace();
        }
        return isPresentAndDisplayed;
    }

    public void clickOnElementInNaviationPage(WebElement element, String elementName){
        clickElementWithJS(element);
        logger.info("clicked on element : "+elementName);
    }
}