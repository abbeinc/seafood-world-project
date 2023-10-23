package net.seafoodworld.pages;

import net.seafoodworld.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppetizersPage {

    public AppetizersPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(xpath = "//a[@href=\"https://www.seafoodworld.net/order/product/buffalo-chicken-wings/\"][@class=\"woocommerce-LoopProduct-link woocommerce-loop-product__link\"]")
    public WebElement buffaloChickenWings;
    @FindBy(xpath ="//h2[@itemprop='name']")
    public WebElement productName;
    @FindBy(xpath = "//p/span/bdi")
    public WebElement price;

    @FindBy(xpath = "//table[@class='variations']//select ")
    public WebElement chooseAnOption;

    @FindBy(xpath = "//select[@id='dipping-sauce']")
    public WebElement dippingSauce;
    @FindBy(xpath = "//div[@class='mkd-quantity-buttons quantity']/input")
    public WebElement quantity;
    @FindBy(xpath = "//button[.='Add to cart']")
    public WebElement addToCart;
    @FindBy(xpath = "//a[.='View cart']")
    public WebElement viewCart;

    @FindBy(xpath = "//td[@data-title='Subtotal'][@class='product-subtotal']/span/bdi")
    public WebElement singleSubtotal;

}
