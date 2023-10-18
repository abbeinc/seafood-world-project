package net.seafoodworld.pages;

import net.seafoodworld.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    public MyAccountPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public static void goToMyAccount(){
        Driver.getDriver().get("https://www.seafoodworld.net/order/my-account/");
    }
    @FindBy(xpath = "//p[contains(.,'Hello')]")
    public WebElement helloMsg;

    @FindBy(xpath = "(//p[contains(.,'Hello')]/strong)[1]")
    public WebElement username;

    @FindBy(xpath = "//a[.='edit your password and account details']")
    public WebElement editYourPassword;

    @FindBy(xpath = "//input[@id='account_first_name']")
    public WebElement editFirstName;

    @FindBy(xpath = "//input[@id='account_last_name']")
    public WebElement editLastName;


    @FindBy(xpath = "//input[@id='account_display_name']")
    public WebElement editDisplayName;

    @FindBy(xpath = "//label[.='New password (leave blank to leave unchanged)']/../span/input")
    public WebElement newPassword;

    @FindBy(xpath = "//label[.='Confirm new password']/../span/input")
    public WebElement confirmNewPassword;

    @FindBy(xpath = "//button[.='Save changes']")
    public WebElement saveChanges;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement loginUsername;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement loginPassword;

    @FindBy(xpath = "//div[@id='rc-anchor-container']//span[@id='recaptcha-anchor']")
    public WebElement notARobot;

    @FindBy(xpath = "//button[.='Log in']")
    public WebElement logInButton;

    @FindBy(xpath = "//iframe[@title='reCAPTCHA']")
    public WebElement iframe;

}