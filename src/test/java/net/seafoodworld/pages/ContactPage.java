package net.seafoodworld.pages;

import io.cucumber.java.zh_cn.假如;
import net.seafoodworld.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
    public ContactPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public static void goToContact(){
        Driver.getDriver().get("https://www.seafoodworld.net/contact/");
    }
    @FindBy(xpath = "//div[.='Thank you for your message. It has been sent.']")
    public WebElement reservationMsg;

    @FindBy(xpath = "//input[@name='your-name']")
    public WebElement yourNameBox;

    @FindBy(xpath = "//input[@name='your-email']")
    public WebElement yourEmailBox;

    @FindBy(xpath = "//label[contains(.,'Your Message')]//textarea[@name='your-message']")
    public WebElement yourMsgBox;

    @FindBy(xpath = "//p//input[@type='submit']")
    public WebElement sendBttn;

    @FindBy(xpath = "//div[.='One or more fields have an error. Please check and try again.']")
    public WebElement warningMsg;

    @FindBy(xpath ="//h3[.='ADDRESS:']/../p" )
    public WebElement address;

    @FindBy(xpath = "//h3[.='OPENING HOURS']/../p")
    public WebElement openingHours;

    @FindBy(xpath = "//h3[.='phone number']/../p")
    public WebElement phoneNumber;

    @FindBy(xpath = "//div//div[@aria-label='Map'][@tabindex='0']")
    public WebElement map;

    @FindBy(xpath = "//iframe[contains(@src, 'https://www.google.com/maps')]")
    public WebElement mapIframe;

    @FindBy(xpath = "//a[@href='https://www.facebook.com/111657595537328?ref=embed_page']/img/..")
    public WebElement facebookLink;
    @FindBy(xpath = "//iframe[@title='fb:page Facebook Social Plugin']")
    public WebElement facebookIframe;

}
//div[@id='easy_facebook_page_plugin-3']