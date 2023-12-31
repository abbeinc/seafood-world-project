package net.seafoodworld.step_definition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import net.seafoodworld.pages.*;
import net.seafoodworld.utility.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OrderOnlineStepDef {
    AppetizersPage appetizersPage = new AppetizersPage();
    MainPage mainPage = new MainPage();
    OnlineOrderPage onlineOrderPage = new OnlineOrderPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Faker faker = new Faker();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofMillis(5000));
    DinnerPlatePage dinnerPlatePage = new DinnerPlatePage();
    CartPage cartPage = new CartPage();

    Actions actions = new Actions(Driver.getDriver());
    String chosenOption;
    String chosenSide;
    String dinnerPlate;
    String subtotal;
    String quantity;
    String price;
    String total;
    double actualTotal;
    double doubleSubtotal=0;
    double expectedTotal;
    double expectedSumSubtotal;
    String productName;
    List<List<String>> lst = new ArrayList<>();
    List<List<String>> expectedLst = new ArrayList<>();
    List<String> productTitle = new ArrayList<>();

    @Given("user at the Order Online page")
    public void user_at_the_order_online_page() {
        MainPage.goToMainPage();
        wait.until(ExpectedConditions.visibilityOf(mainPage.orderOnline));
        mainPage.orderOnline.click();
    }

    @When("user click Dinner Plate")
    public void user_click_dinner_plate() {
        js.executeScript("window.scrollBy(0,500)");
        wait.until(ExpectedConditions.visibilityOf(onlineOrderPage.dinnerPlate));
        onlineOrderPage.dinnerPlate.click();
        wait.until(ExpectedConditions.visibilityOf(dinnerPlatePage.largeShrimp));
        dinnerPlatePage.largeShrimp.click();

    }

    @When("choose Large Shrimp and choosing option \\(grilled) and side \\(asparagus) press Add to cart")
    public void choose_large_shrimp_and_choosing_option_grilled_and_side_asparagus_press_add_to_cart() throws InterruptedException {

        dinnerPlate = dinnerPlatePage.dinnerPlateProductName.getText();
        wait.until(ExpectedConditions.visibilityOf(dinnerPlatePage.chooseOption));
        Select select = new Select(dinnerPlatePage.chooseOption);
        select.selectByVisibleText("Grilled");
        chosenOption = select.getFirstSelectedOption().getText();
        actions.pause(1000).perform();
        Select select1 = new Select(dinnerPlatePage.chooseSide);
        select1.selectByVisibleText("Asparagus");
        chosenSide = select1.getFirstSelectedOption().getText();
        js.executeScript("window.scrollBy(0,500)");
        actions.moveToElement(dinnerPlatePage.quantity).click().sendKeys(Keys.DELETE).sendKeys(Keys.BACK_SPACE).perform();
        wait.until(ExpectedConditions.visibilityOf(dinnerPlatePage.quantity));
        dinnerPlatePage.quantity.sendKeys("1");
        quantity = dinnerPlatePage.quantity.getAttribute("value");
        price = dinnerPlatePage.price.getText();

        actions.pause(2000).perform();
        dinnerPlatePage.addToCart.click();
        actions.pause(2000).perform();
        List<String> act = new ArrayList<>();
        String product = dinnerPlate + " - " + chosenOption + ", " + chosenSide;
        act.add(product);
        act.add(price);

        expectedLst.add(act);



    }


    @Then("user should see his order in the cart")
    public void userShouldSeeHisOrderInTheCart() {
        wait.until(ExpectedConditions.visibilityOf(dinnerPlatePage.viewCart));
        dinnerPlatePage.viewCart.click();
        String expectedResult = dinnerPlate + "-" + chosenOption + "," + chosenSide;
        for (WebElement each : cartPage.productName) {

            if (each.getText().equals(expectedResult)) {
                Assert.assertEquals(each.getText(), expectedResult);
            }
        }

    }

    @And("total price should be the sum of subtotal prices plus {int}% tax")
    public void totalPriceShouldBeTheSumOfSubtotalPricesPlusTax(double tax) {
        double doubleTax =tax/100;
        js.executeScript("window.scrollBy(0,500)");
        actions.pause(1000);
        wait.until(ExpectedConditions.visibilityOf(cartPage.total));
        total = cartPage.total.getText();
        actualTotal =  Double.parseDouble(total.substring(total.indexOf("$")+1));
        subtotal = cartPage.subtotal.getText();
        doubleSubtotal = Double.parseDouble(subtotal.substring(subtotal.indexOf("$")+1));
        expectedTotal = doubleSubtotal*doubleTax+doubleSubtotal;
        Assert.assertEquals(expectedTotal,actualTotal, 0.01);


    }


    @And("choose Chicken Tenders and choosing option \\(broccoli)")
    public void chooseChickenTendersAndChoosingOptionBroccoli() {


        onlineOrderPage.orderOnline.click();
        wait.until(ExpectedConditions.visibilityOf(onlineOrderPage.dinnerPlate));
        onlineOrderPage.dinnerPlate.click();
        js.executeScript("window.scrollBy(0,300)");
        wait.until(ExpectedConditions.visibilityOf(dinnerPlatePage.chickenTenders));
        dinnerPlatePage.chickenTenders.click();
        dinnerPlate = dinnerPlatePage.dinnerPlateProductName.getText();
        Select select = new Select(dinnerPlatePage.chickenTendersChooseAnOption);
        select.selectByVisibleText("Broccoli");
        chosenOption = select.getFirstSelectedOption().getText();
        price = dinnerPlatePage.price.getText();
        wait.until(ExpectedConditions.visibilityOf(dinnerPlatePage.addToCart));
        dinnerPlatePage.addToCart.click();
        List<String> act = new ArrayList<>();
        String product = dinnerPlate + " - " + chosenOption;
        act.add(product);
        act.add(price);
        expectedLst.add(act);
        wait.until(ExpectedConditions.visibilityOf(dinnerPlatePage.viewCart));
        dinnerPlatePage.viewCart.click();


    }

    @Then("user should see his two orders")
    public void userShouldSeeHisTwoOrders() {
        js.executeScript("window.scrollBy(0,300)");

        List<WebElement> rows = cartPage.table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<String> rowData = new ArrayList<>();
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                rowData.add(cell.getText());
            }
            lst.add(rowData);

        }


        for (List<String> list : lst) {
            int count = 0;
            boolean assertVar = false;
            for (List<String> each : expectedLst) {
                for (String s : each) {
                    if (list.contains(s)) {
                        count++;
                    } else { break; }
                }
               }
            if(count>=2){
                assertVar=true;
                Assert.assertTrue(assertVar);
            }

        }



    }

    @And("user should see his correct total prices with {int}% tax")
    public void userShouldSeeHisCorrectTotalPricesWithTax(double tax) {

        double doubleTax =tax/100;

        for (List<String> list : expectedLst) {

            for (String s : list) {
                productTitle.add(s);
                break;

            }
        }

        for (List<String> list : lst) {
            for (String s : productTitle) {
                if(list.contains(s)){
                    subtotal = list.get(list.size()-1);
                    doubleSubtotal = Double.parseDouble(subtotal.substring(subtotal.indexOf("$")+1));
                    expectedSumSubtotal+=doubleSubtotal;
                       }
            }
        }


        js.executeScript("window.scrollBy(0,500)");
        actions.pause(1000);
        wait.until(ExpectedConditions.visibilityOf(cartPage.total));
        total = cartPage.total.getText();
        actualTotal =  Double.parseDouble(total.substring(total.indexOf("$")+1));
        expectedTotal = expectedSumSubtotal*doubleTax+expectedSumSubtotal;
        Assert.assertEquals(expectedTotal,actualTotal, 0.01);




    }


    @When("user click Appetizers and and choose Buffalo Chicken Wings")
    public void userClickAppetizersAndAndChooseBuffaloChickenWings() {
        js.executeScript("window.scrollBy(0,500)");
        onlineOrderPage.appetizersPlate.click();
        js.executeScript("window.scrollBy(0,900)");
        wait.until(ExpectedConditions.visibilityOf(appetizersPage.buffaloChickenWings));
        actions.click(appetizersPage.buffaloChickenWings).click().perform();


    }
    @When("user pick {string} and {string}")
    public void user_pick_and(String string, String string2) {

        Select select1 = new Select(appetizersPage.chooseAnOption);
        select1.selectByVisibleText(string);
        Select select2 = new Select(appetizersPage.dippingSauce);
        select2.selectByVisibleText(string2);

    }
    @When("choose {int} plates and click Add to cart and  view Cart")
    public void choose_plates_and_click_add_to_cart_and_view_cart(Integer int1) {
        String quantity = int1.toString();
        js.executeScript("window.scrollBy(0,300)");
        actions.click(appetizersPage.quantity).sendKeys(Keys.BACK_SPACE).sendKeys(quantity).perform();
        actions.pause(2000).perform();
        actions.click(appetizersPage.addToCart).sendKeys(Keys.ENTER).perform();
        actions.pause(1000).perform();
        wait.until(ExpectedConditions.visibilityOf(appetizersPage.viewCart));
        appetizersPage.viewCart.click();

    }
    @Then("total price will be subtotal plus {int}% tax")
    public void total_price_will_be_subtotal_plus_tax(double db1) {

        double tax = db1/100;
    subtotal = appetizersPage.singleSubtotal.getText();
    double doSubtotal = Double.parseDouble(subtotal.substring(subtotal.indexOf("$")+1));
    double expectedTotal = doSubtotal*tax+doSubtotal;
        js.executeScript("window.scrollBy(0,500)");
    total = cartPage.total.getText();
    actualTotal = Double.parseDouble(total.substring(total.indexOf("$")+1));

    Assert.assertEquals(expectedTotal, actualTotal,0.01);



    }



}
