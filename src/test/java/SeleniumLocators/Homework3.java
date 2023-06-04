package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Homework3 { //HOMEWORK 3

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement Username = driver.findElement(By.id("user-name"));
        Username.sendKeys("standard_user");
        Thread.sleep(2000);
        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys("secret_sauce");
        Thread.sleep(2000);
        WebElement button = driver.findElement(By.id("login-button"));
        button.click();
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        System.out.println(actualURL.equals(expectedURL) ? "PASSED" : "FAILED ");
        driver.quit();
    }
}