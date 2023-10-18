package net.seafoodworld.pages;

import net.seafoodworld.utility.ConfigReader;
import net.seafoodworld.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//a[.='Order Online']")
    public WebElement orderOnline;

    public static void goToMainPage(){
        Driver.getDriver().get(ConfigReader.read("seafoodworld"));
    }



}
