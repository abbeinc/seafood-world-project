package net.seafoodworld.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private Driver() { }


    private static final   InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();


    public static WebDriver getDriver() {

        String browserName = ConfigReader.read("browser");

        if (driverPool.get() == null) {
            switch (browserName.toLowerCase()) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions opt = new ChromeOptions();
                    opt.addArguments("--remote-allow-origins=*");
                    driverPool.set(new ChromeDriver(opt));
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    break;

                default:
                    System.out.println("Unknown browser type! " + browserName);

            }

            return driverPool.get();

        } else {

            return driverPool.get();

        }
    }






    public static void closeBrowser () {

        if (driverPool.get()!=null) {
            driverPool.get().quit();
            driverPool.set(null);
        }


    }
}
