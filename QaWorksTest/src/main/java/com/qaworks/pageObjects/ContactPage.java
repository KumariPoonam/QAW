package com.qaworks.pageObjects;

import com.qaworks.Page;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends Page {


    @FindBy(xpath = "//input[@id='ctl00_MainContent_NameBox']")
    public WebElement nameField;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_EmailBox']")
    public WebElement emailField;

    @FindBy(xpath = "//textarea[@id='ctl00_MainContent_MessageBox']")
    public WebElement messageField;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement sendButton;



    public boolean isContactPageElementsPresentAndDisplayed(WebElement element){
        boolean isPresentAndDisplayed= false;

        try{
            isElementPresentAndDisplayed(element);
            logger.info("\nThe Contact page element present and displayed status is : "+isPresentAndDisplayed+" .");
        }catch (NoSuchElementException nsee){
            nsee.printStackTrace();
        }
        return isPresentAndDisplayed;
    }

    public void setValueInInputElelemtInContactUsPage(WebElement elemetInContactUsPage, String inputValue, String fieldName){
        elemetInContactUsPage.sendKeys(inputValue);
        logger.info("value set is : "+inputValue+" in field"+fieldName);
    }

    public void clickOnSendButtonInContactUsPage(){
        clickElementWithJS(sendButton);
        logger.info("Clicked the Send Button");
    }

    public String getTextFromInputFiledsInContactUsPage(WebElement element){
        String text="";
        try{
            text= element.getText();
        }catch (NoSuchElementException nsee){
            nsee.printStackTrace();
        }
        return text;
    }
}