package net.seafoodworld.step_definition;

import net.seafoodworld.utility.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {
    @Before("@regression")
    public void setupDriver() {

       // Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        Driver.getDriver().manage().window().maximize();
    }

    @After("@regression")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Attached img");
        }
        Driver.closeBrowser();
    }
}
