package net.seafoodworld.step_definition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seafoodworld.pages.MainPage;
import net.seafoodworld.pages.MyAccountPage;
import net.seafoodworld.pages.OnlineOrderPage;
import net.seafoodworld.utility.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

public class RegisterAccStepDef {
    MainPage mainPage = new MainPage();
    OnlineOrderPage onlineOrderPage = new OnlineOrderPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Faker faker = new Faker();

    Actions actions = new Actions(Driver.getDriver());
    String username;
    String password;

    @Given("user at the My Account page")
    public void user_at_the_my_account_page() {
       MainPage.goToMainPage();
        mainPage.orderOnline.click();
        onlineOrderPage.myAccount.click();
    }
    @When("user enters valid username, email and click register button")
    public void user_enters_valid_username_email_and_click_register_button() {
        username = faker.name().firstName();
        js.executeScript("window.scrollBy(0, 500)");
        onlineOrderPage.registerUsername.sendKeys(username);
        onlineOrderPage.registerEmail.sendKeys(faker.name().firstName()+"@gmail.com");
        onlineOrderPage.registerButton.click();
    }
    @Then("user should see message Hello username")
    public void user_should_see_message_hello_username() {
        String actualUsername="";
     if(myAccountPage.username.getText().startsWith(username)){
         actualUsername = username;
     }
      String msg = myAccountPage.helloMsg.getText()+" "+actualUsername;
      Assert.assertEquals("Hello "+username,"Hello "+actualUsername );
    }

    @And("user can edit password and account")
    public void userCanEditPasswordAndAccount() throws InterruptedException {

        password = faker.number().digits(5)+faker.name().firstName();
        myAccountPage.editYourPassword.click();
        myAccountPage.editFirstName.sendKeys(faker.name().firstName());
        myAccountPage.editLastName.sendKeys(faker.name().lastName());
        myAccountPage.editDisplayName.sendKeys(faker.name().firstName());
        js.executeScript("window.scrollBy(0,500)" );
        myAccountPage.newPassword.click();
        actions.moveToElement(myAccountPage.newPassword).sendKeys(password).perform();
        myAccountPage.confirmNewPassword.click();
        actions.moveToElement(myAccountPage.confirmNewPassword).sendKeys(password).perform();
        actions.pause(3).perform();
        myAccountPage.saveChanges.click();
    }
    @Then("user should not be able to login")
    public void userShouldNotBeAbleToLogin() {
        String expectedUrl = "https://www.seafoodworld.net/order/my-account/edit-account/";
        Assert.assertEquals(expectedUrl, Driver.getDriver().getCurrentUrl());
    }
}
