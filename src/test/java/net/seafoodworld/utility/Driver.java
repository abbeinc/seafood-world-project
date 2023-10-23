package net.seafoodworld.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private Driver(){
    }

    private static WebDriver driver;

    public static WebDriver getDriver(){

        String browserName = ConfigReader.read("browser");
        if (driver ==null){
                switch (browserName.toLowerCase()){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver =new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver =new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;

                case "edge":
                   WebDriverManager.edgedriver().setup();
                   driver = new EdgeDriver();
                   driver.manage().window().maximize();
                    break;
                default:
                    driver =null;
                    System.out.println("Unknown browser type! "+browserName);

            }

            return driver;
            }else {
                    return driver;
            }
             }

    public static void closeBrowser(){
        if(driver !=null){
            driver.quit();
            driver =null;
        }
    }

}
