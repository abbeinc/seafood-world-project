package net.seafoodworld.pages;

import net.seafoodworld.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DinnerPlatePage {
    public DinnerPlatePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//a[@href='https://www.seafoodworld.net/order/product/large-shrimp/'][contains(@class, 'woocommerce')]" )
    public WebElement largeShrimp;

    @FindBy(xpath = "//select[@id='choose']")
    public WebElement chooseOption;

    @FindBy(xpath = "//select[@id='pa_side']")
    public WebElement chooseSide;


    @FindBy(xpath = "//button[.='Add to cart']")
    public WebElement addToCart;


    @FindBy(xpath = "//a[.='View cart']")
    public WebElement viewCart;

    @FindBy(xpath = "//h2[@itemprop='name']")
    public WebElement dinnerPlateProductName;

    @FindBy(xpath = "//div[@class=\"mkd-quantity-buttons quantity\"]/input")
    public WebElement quantity;

    @FindBy(xpath = "//p/span/bdi")
    public WebElement price;

    @FindBy(xpath = "//a[@href=\"https://www.seafoodworld.net/order/product/chicken-tenders/\"][@class=\"woocommerce-LoopProduct-link woocommerce-loop-product__link\"]")
    public WebElement chickenTenders;

    @FindBy(xpath = "//table[@class=\"variations\"]//select ")
    public WebElement chickenTendersChooseAnOption;





}
