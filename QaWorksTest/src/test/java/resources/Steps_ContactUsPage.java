package resources;

import com.qaworks.pageObjects.ContactPage;
import com.qaworks.pageObjects.HomePage;
import com.qaworks.pageObjects.NavigationPanel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class Steps_ContactUsPage {

    HomePage homePage = new HomePage();
    NavigationPanel navigationPanel = new NavigationPanel();
    ContactPage contactPage = new ContactPage();

    @Given("^I am on homepage$")
    public void iAmOnHomepage() throws Throwable {
        Assert.assertTrue(homePage.isHomePageElementsPresentAndDisplayed(homePage.header_Technology));
        Assert.assertTrue(homePage.isHomePageElementsPresentAndDisplayed(homePage.header_Work));
        Assert.assertTrue(homePage.isHomePageElementsPresentAndDisplayed(homePage.header_Services));
    }

    @And("^I have navigate to the Contact page$")
    public void iHaveNavigateToTheContactPage() throws Throwable {
        navigationPanel.clickOnElementInNaviationPage(navigationPanel.contactTab,"Contact Tab");
    }

    @And("^I enter Name field with \"([^\"]*)\"$")
    public void iEnterNameFieldWith(String arg0) throws Throwable {
        contactPage.setValueInInputElelemtInContactUsPage(contactPage.nameField,arg0," Name");
    }

    @And("^I enter Email field with \"([^\"]*)\"$")
    public void iEnterEmailFieldWith(String arg0) throws Throwable {
        contactPage.setValueInInputElelemtInContactUsPage(contactPage.emailField,arg0," Email");
    }

    @And("^I enter Message field with\"([^\"]*)\"$")
    public void iEnterMessageFieldWith(String arg0) throws Throwable {
        contactPage.setValueInInputElelemtInContactUsPage(contactPage.messageField,arg0," Message");
    }

    @And("^I click on the Send button$")
    public void iClickOnTheSendButton() throws Throwable {
        contactPage.clickOnSendButtonInContactUsPage();
    }

    @Then("^I see that the message has been sent$")
    public void iSeeThatTheMessageHasBeenSent() throws Throwable {
        // I will ensure that the field have gone blank
        Assert.assertEquals("",contactPage.getTextFromInputFiledsInContactUsPage(contactPage.nameField));
        Assert.assertEquals("",contactPage.getTextFromInputFiledsInContactUsPage(contactPage.emailField));
        Assert.assertEquals("",contactPage.getTextFromInputFiledsInContactUsPage(contactPage.messageField));

    }
}
