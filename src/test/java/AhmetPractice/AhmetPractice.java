package AhmetPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class AhmetPractice {

    public static WebDriver driver;

    public static void openBrowserAndLaunchApplication(String url,String browser) {



        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;
        }
        // maximize the screen
        driver.manage().window().maximize();
        //navigate to url
        driver.get(url);
    }

    public  static  void closeBrowser(){
        if (driver!=null){
            driver.quit();

    }
}}