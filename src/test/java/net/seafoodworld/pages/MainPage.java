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

    @FindBy(xpath = "//li[@id='menu-item-1831']//a[.='Reservation']")
    public WebElement reservation;

    @FindBy(xpath = "//li[@id='menu-item-900']/a[.='Contact']")
    public WebElement contact;

    public static void goToMainPage(){
        Driver.getDriver().get(ConfigReader.read("seafoodworld"));
    }



}
