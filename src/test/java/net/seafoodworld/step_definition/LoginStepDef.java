package net.seafoodworld.step_definition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seafoodworld.pages.MainPage;
import net.seafoodworld.pages.MyAccountPage;
import net.seafoodworld.pages.OnlineOrderPage;
import net.seafoodworld.utility.ConfigReader;
import net.seafoodworld.utility.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

public class LoginStepDef {


    MainPage mainPage = new MainPage();
    OnlineOrderPage onlineOrderPage = new OnlineOrderPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Faker faker = new Faker();

    Actions actions = new Actions(Driver.getDriver());
    String email = ConfigReader.read("email");
    String password = ConfigReader.read("password");
    @When("user enters registered email and password")
    public void user_enters_registered_email_and_password() throws InterruptedException {
    myAccountPage.loginUsername.sendKeys(email);
    myAccountPage.loginPassword.sendKeys(password);

    Driver.getDriver().switchTo().frame(myAccountPage.iframe);
    js.executeScript("window.scrollBy(0,400)");
    actions.pause(1000).perform();
    actions.moveToElement(myAccountPage.notARobot).click().perform();
    actions.pause(1000).perform();
    Driver.getDriver().switchTo().parentFrame();

        js.executeScript("window.scrollBy(0,100)");
    myAccountPage.logInButton.click();

    }
    @Then("user should see his account")
    public void user_should_see_his_account() {
    String username = ConfigReader.read("username");
    String actualUsername = "";
    if(myAccountPage.username.getText().startsWith(username)){
        actualUsername=username;
    }

        Assert.assertEquals(username,actualUsername);
    }


    @When("user enters not registered email and password and press login")
    public void userEntersNotRegisteredEmailAndPasswordAndPressLogin() {
    String expetedTitle = "Seafood World – Online Order – Seafood World Calabash Seafood And Steak Buffet";
    myAccountPage.loginUsername.sendKeys(faker.name().firstName()+"@mail.com");
    myAccountPage.loginPassword.sendKeys(faker.number().digits(5)+faker.name().firstName());
        Driver.getDriver().switchTo().frame(myAccountPage.iframe);
        js.executeScript("window.scrollBy(0,400)");
        actions.pause(1000).perform();
        actions.moveToElement(myAccountPage.notARobot).click().perform();
        actions.pause(1000).perform();
        Driver.getDriver().switchTo().parentFrame();

        js.executeScript("window.scrollBy(0,100)");
        myAccountPage.logInButton.click();
        Assert.assertEquals(expetedTitle, Driver.getDriver().getTitle());

    }
}
