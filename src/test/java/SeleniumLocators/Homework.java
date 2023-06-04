package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.SQLOutput;

public class Homework { //HOMEWORK1

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box/");
        WebElement firstName = driver.findElement(By.xpath("//input[@id='userName']"));
        firstName.sendKeys("John");
       Thread.sleep(2000);
       WebElement eMail = driver.findElement(By.xpath("//input[@id='userEmail']"));
       eMail.sendKeys("john@gmail.com");
        Thread.sleep(2000);
        WebElement CurrentAddress = driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
        CurrentAddress.sendKeys("Random Address");
        Thread.sleep(2000);
        WebElement PermanentAddress = driver.findElement(By.id("permanentAddress"));
        PermanentAddress.sendKeys("different address");
        Thread.sleep(2000);
        WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
        button.click();
        System.out.println(firstName.isDisplayed()? "passed" : "failed");
        System.out.println(eMail.isDisplayed()? "passed" : "failed");
        System.out.println(CurrentAddress.isDisplayed()? "passed" : "failed");
        System.out.println(PermanentAddress.isDisplayed()? "passed" : "failed");

        driver.quit();
        }


    }



