package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchMultipleWindow {


    @Test
    public void practice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = driver;
        js.executeScript("window.open('https://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");
        String mainPageId = driver.getWindowHandle();
        Set<String> allPagesID = driver.getWindowHandles();
        for (String id : allPagesID) {
            if (!id.equals(mainPageId)) {
                driver.switchTo().window(id);
                break;

            }
        }
        BrowserUtils.switchByTitle(driver, "Contact");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        BrowserUtils.switchByTitle(driver,"Kickstart");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        BrowserUtils.switchByTitle(driver,"Courses");
        System.out.println(driver.getTitle());
    }}