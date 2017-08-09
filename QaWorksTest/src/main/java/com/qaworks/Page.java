package com.qaworks;

import com.google.common.base.Function;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Aniket Wadkar on 11/06/2017.
 */
public abstract class Page extends BrowserFactory{


    protected Logger logger = LoggingFactory.getLogger();

    public void clickElementWithJS(WebElement element){

        try{JavascriptExecutor _driver = (JavascriptExecutor)getDriver();
            waitForElementToBeVisible(element);
            waitForPageLoad();
            element.click();}
        catch (StaleElementReferenceException sere){
                logger.info("Stale element reference excetion occured !!");
                sere.printStackTrace();
        }
    }

    public void waitForElementToBeVisible(final WebElement element){
        FluentWait<WebElement> customWait = new FluentWait<WebElement>(element)
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(StaleElementReferenceException.class);

        customWait.until(new Function<WebElement, Boolean>() {
            public Boolean apply(WebElement element) {
                try {
                    element.isDisplayed();
                    return true;
                }
                catch (Exception e) {
                    return false;
                }
            }
        });
    }




    public void waitForPageLoad() {

        Wait<WebDriver> wait = new WebDriverWait(getDriver(), 30);
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("Current Window State       : "
                        + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
    }



    public WebElement explicitWaitForElement(WebElement element, long miliseconds)
    {
        WebDriverWait wait = new WebDriverWait(getDriver(), miliseconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        logger.info("explicitling waiting for : "+miliseconds+" milliseconds.\n" );
        return element;
    }


    protected void moveToElement(WebElement element){
        Actions action = new Actions(this.getDriver());
        try{
            action.moveToElement(element);
            waitForElementToBeVisible(element);
            logger.info("Moved to Element.\n");
        }
        catch (Exception e){
            e.printStackTrace();

        }
    }

    /**
     *
     * @param element check that the element is present and displayed
     * @return in boolean the present and displayed state of the element
     */
    protected boolean isElementPresentAndDisplayed(WebElement element){
        boolean isPresentAndDisplayed = false;
        try {
            isPresentAndDisplayed = element.isDisplayed();
            logger.info("The current displayed status " + isPresentAndDisplayed);
        }
        catch (NoSuchElementException nsee){
            isPresentAndDisplayed= false ;
            logger.info("The current displayed status "+isPresentAndDisplayed);

        }
        return isPresentAndDisplayed;
    }

}
