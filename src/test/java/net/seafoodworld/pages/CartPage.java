package net.seafoodworld.pages;

import net.seafoodworld.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    public CartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//tr[@class=\"woocommerce-cart-form__cart-item cart_item\"]/td[@data-title='Product']")
    public List<WebElement> productName;

    @FindBy(xpath = "//td[@data-title='Price']/span/bdi")
    public WebElement price;

    @FindBy(xpath = "//div[@class=\"mkd-quantity-buttons quantity\"]/input")
    public WebElement quantity;

    @FindBy(xpath = "//table[@class=\"shop_table shop_table_responsive cart woocommerce-cart-form__contents\"]")
    public WebElement table;

    @FindBy(xpath = "//td[@data-title=\"Subtotal\"][@class='product-subtotal']//span/bdi")
    public WebElement subtotal;

    @FindBy(xpath = "//td[@data-title='Total']//bdi")
    public WebElement total;

    @FindBy(xpath = "//a[contains(.,'Proceed to checkout')]")
    public WebElement proceedToCheckout;

}
