package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Homework2 {  //HOMEWORK 2
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
        Password.sendKeys("secret_sauc");
        Thread.sleep(2000);
        WebElement button = driver.findElement(By.id("login-button"));
        button.click();
        WebElement error = driver.findElement(By.xpath("//button[@class='error-button']"));
        System.out.println((error.isDisplayed() ? "PASSED" : "FAILED"));
        driver.quit();



    }
}
