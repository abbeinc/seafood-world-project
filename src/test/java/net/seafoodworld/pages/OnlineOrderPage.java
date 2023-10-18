package net.seafoodworld.pages;

import net.seafoodworld.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnlineOrderPage {
    public OnlineOrderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//li[@id='nav-menu-item-9507']/a")
    public WebElement myAccount;

    @FindBy(xpath = "//input[@id='reg_username']")
    public WebElement registerUsername;

    @FindBy(xpath = "//input[@id='reg_email']")
    public WebElement registerEmail;

    @FindBy(xpath = "//button[.='Register']")
    public WebElement registerButton;

    @FindBy(xpath = "//a[@href='https://www.seafoodworld.net/order/category/dinner-plate/']")
    public WebElement dinnerPlate;

    @FindBy(xpath = "//ul[@id=\"menu-main\"]//span/span[contains(.,'– Order Online –')]")
    public WebElement orderOnline;






}
