package net.seafoodworld.step_definition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.et.Ja;
import net.seafoodworld.pages.ContactPage;
import net.seafoodworld.pages.MainPage;
import net.seafoodworld.utility.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class ReservationStepDef {

    MainPage mainPage = new MainPage();
    ContactPage contactPage = new ContactPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofMillis(5000));
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Faker faker = new Faker();

    @Given("user at the contact page")
    public void user_at_the_contact_page() {
        MainPage.goToMainPage();
        wait.until(ExpectedConditions.titleIs("Seafood World Calabash Seafood Buffet | Myrtle Beach Seafood Buffet Restaurant"));
        js.executeScript("window.scrollBy(0,700)");
        wait.until(ExpectedConditions.visibilityOf(mainPage.reservation));
        actions.moveToElement(mainPage.reservation).pause(1000).moveToElement(mainPage.contact).click().perform();

    }
    @When("user enters name, email, message and click send")
    public void user_enters_name_email_message_and_click_send() {
     String contactUrl = "https://www.seafoodworld.net/contact/";
     wait.until(ExpectedConditions.urlMatches(contactUrl));
     String actualTitle = Driver.getDriver().getTitle().trim();
     String expectedTitle = "Seafood World Seafood Buffet Contact";
     Assert.assertEquals(expectedTitle,actualTitle);
     js.executeScript("window.scrollBy(0,1000)");
     wait.until(ExpectedConditions.visibilityOf(contactPage.yourNameBox));
     contactPage.yourNameBox.sendKeys(faker.name().fullName());
     contactPage.yourEmailBox.sendKeys(faker.name().firstName()+"@gmail.com");
     js.executeScript("window.scrollBy(0,300)");
     wait.until(ExpectedConditions.visibilityOf(contactPage.yourMsgBox));
     contactPage.yourMsgBox.sendKeys(faker.chuckNorris().fact());
     contactPage.sendBttn.click();



    }
    @Then("user should see message")
    public void user_should_see_message() {
        wait.until(ExpectedConditions.visibilityOf(contactPage.reservationMsg));
        Assert.assertTrue(contactPage.reservationMsg.isDisplayed());
    }
    @When("user enters email, message and click send")
    public void userEntersEmailMessageAndClickSend() {
        String contactUrl = "https://www.seafoodworld.net/contact/";
        wait.until(ExpectedConditions.urlMatches(contactUrl));
        String actualTitle = Driver.getDriver().getTitle().trim();
        String expectedTitle = "Seafood World Seafood Buffet Contact";
        Assert.assertEquals(expectedTitle,actualTitle);
        js.executeScript("window.scrollBy(0,1000)");
        wait.until(ExpectedConditions.visibilityOf(contactPage.yourNameBox));
        contactPage.yourEmailBox.sendKeys(faker.name().firstName()+"@gmail.com");
        js.executeScript("window.scrollBy(0,300)");
        wait.until(ExpectedConditions.visibilityOf(contactPage.yourMsgBox));
        contactPage.yourMsgBox.sendKeys(faker.chuckNorris().fact());
        contactPage.sendBttn.submit();
        js.executeScript("window.scrollBy(0,200)");

        
    }

    @Then("user should see warning message")
    public void userShouldSeeWarningMessage() {
        js.executeScript("window.scrollBy(0,200)");
        wait.until(ExpectedConditions.visibilityOf(contactPage.warningMsg));
        Assert.assertTrue(contactPage.warningMsg.isDisplayed());
    }

    @When("user enters name, message and click send")
    public void userEntersNameMessageAndClickSend() {
        String contactUrl = "https://www.seafoodworld.net/contact/";
        wait.until(ExpectedConditions.urlMatches(contactUrl));
        String actualTitle = Driver.getDriver().getTitle().trim();
        String expectedTitle = "Seafood World Seafood Buffet Contact";
        Assert.assertEquals(expectedTitle,actualTitle);
        js.executeScript("window.scrollBy(0,1000)");
        wait.until(ExpectedConditions.visibilityOf(contactPage.yourNameBox));
        contactPage.yourNameBox.sendKeys(faker.name().fullName());
        js.executeScript("window.scrollBy(0,300)");
        wait.until(ExpectedConditions.visibilityOf(contactPage.yourMsgBox));
        contactPage.yourMsgBox.sendKeys(faker.chuckNorris().fact());
        wait.until(ExpectedConditions.visibilityOf(contactPage.sendBttn));
        contactPage.sendBttn.submit();

    }

    @When("user enters name, email  and click send")
    public void userEntersNameEmailAndClickSend() {
        String contactUrl = "https://www.seafoodworld.net/contact/";
        wait.until(ExpectedConditions.urlMatches(contactUrl));
        String actualTitle = Driver.getDriver().getTitle().trim();
        String expectedTitle = "Seafood World Seafood Buffet Contact";
        Assert.assertEquals(expectedTitle,actualTitle);
        js.executeScript("window.scrollBy(0,1000)");
        wait.until(ExpectedConditions.visibilityOf(contactPage.yourNameBox));
        contactPage.yourNameBox.sendKeys(faker.name().fullName());
        contactPage.yourEmailBox.sendKeys(faker.name().firstName()+"@gmail.com");
        js.executeScript("window.scrollBy(0,300)");
        contactPage.sendBttn.submit();;
    }

    @When("user click send button")
    public void userClickSendButton() {
        String contactUrl = "https://www.seafoodworld.net/contact/";
        wait.until(ExpectedConditions.urlMatches(contactUrl));
        String actualTitle = Driver.getDriver().getTitle().trim();
        String expectedTitle = "Seafood World Seafood Buffet Contact";
        Assert.assertEquals(expectedTitle,actualTitle);
        js.executeScript("window.scrollBy(0,1000)");
        contactPage.sendBttn.click();
    }
    @Given("user goes directly to the Contact page")
    public void userGoesDirectlyToTheContactPage() {
        ContactPage.goToContact();
    }
    @When("user enters name, {string}, message and click send")
    public void userEntersNameMessageAndClickSend(String str) {
        String contactUrl = "https://www.seafoodworld.net/contact/";
        wait.until(ExpectedConditions.urlMatches(contactUrl));
       // String actualTitle = Driver.getDriver().getTitle().trim();
       // String expectedTitle = "Seafood World Seafood Buffet Contact";
       // Assert.assertEquals(expectedTitle,actualTitle);
        js.executeScript("window.scrollBy(0,1000)");
        wait.until(ExpectedConditions.visibilityOf(contactPage.yourNameBox));
        contactPage.yourNameBox.sendKeys(faker.name().fullName());
        contactPage.yourEmailBox.sendKeys(str);
        js.executeScript("window.scrollBy(0,300)");
        actions.pause(1000).perform();
        wait.until(ExpectedConditions.visibilityOf(contactPage.yourMsgBox));
        contactPage.yourMsgBox.sendKeys(faker.chuckNorris().fact());
        contactPage.sendBttn.submit();

    }


    @When("user scroll page down")
    public void userScrollPageDown() {
        String contactUrl = "https://www.seafoodworld.net/contact/";
        wait.until(ExpectedConditions.urlMatches(contactUrl));
        js.executeScript("window.scrollBy(0,500)");




    }

    @Then("user should see correct information")
    public void userShouldSeeCorrectInformation() {
        String actualAddressTemp = contactPage.address.getText().trim();
        String[] arr = actualAddressTemp.split("\n");

        String actualAddress ="";
        for (String s : arr) {
            actualAddress+=s.trim()+" ";

        }
        actualAddress=actualAddress.trim();

        String actualOpeningHours = contactPage.openingHours.getText().trim();
        String actualPhone = contactPage.phoneNumber.getText().trim();

        String expectedAddress = "411 N Kings Hwy Myrtle Beach, SC, 29577";
        String expectedOpeningHours = "12:00 PM – 11:00 PM";
        String expectedPhone = "(843) 626-7896";

        Assert.assertEquals(expectedAddress, actualAddress);
        Assert.assertEquals(expectedOpeningHours, actualOpeningHours);
        Assert.assertEquals(expectedPhone, actualPhone);



    }

    @When("user scroll all the way down")
    public void userScrollAllTheWayDown() {
        String contactUrl = "https://www.seafoodworld.net/contact/";
        wait.until(ExpectedConditions.urlMatches(contactUrl));
        String actualTitle = Driver.getDriver().getTitle().trim();
        String expectedTitle = "Seafood World Seafood Buffet Contact";
        Assert.assertEquals(expectedTitle,actualTitle);
        js.executeScript("window.scrollBy(0,1500)");



    }

    @Then("user should see map")
    public void userShouldSeeMap() {
        Driver.getDriver().switchTo().frame(contactPage.mapIframe);
        wait.until(ExpectedConditions.visibilityOf(contactPage.map));
        Assert.assertTrue(contactPage.map.isDisplayed());
    }

    @When("user click on the facebook picture link")
    public void userClickOnTheFacebookPictureLink()  {
        String contactUrl = "https://www.seafoodworld.net/contact/";
        wait.until(ExpectedConditions.urlMatches(contactUrl));
        String actualTitle = Driver.getDriver().getTitle().trim();
        String expectedTitle = "Seafood World Seafood Buffet Contact";
        Assert.assertEquals(expectedTitle,actualTitle);
        js.executeScript("window.scrollBy(0,800)");
        wait.until(ExpectedConditions.visibilityOf(contactPage.facebookIframe));
        Driver.getDriver().switchTo().frame(contactPage.facebookIframe);
        js.executeScript("window.scrollBy(0,100)");
        wait.until(ExpectedConditions.visibilityOf(contactPage.facebookLink));
        wait.until(ExpectedConditions.visibilityOf(contactPage.facebookLink));

        contactPage.facebookLink.click();

    }

    @Then("user should see Facebook page")
    public void userShouldSeeFacebookPage() {
        Set<String> wHandles = Driver.getDriver().getWindowHandles();
        for (String wHandle : wHandles) {
            Driver.getDriver().switchTo().window(wHandle);
            if(Driver.getDriver().getTitle().equals("Seafood World Restaurant | Myrtle Beach SC | Facebook")){
                Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("https://www.facebook.com/seafoodbuffetmyrtlebeach?ref=embed_page"));
            }

        }
    }
}
