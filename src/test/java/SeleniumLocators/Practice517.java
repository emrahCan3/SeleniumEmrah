package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Practice517 {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("remote-allow-origins=*");
        //then create your driver to start automation

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.youtube.com/");
        String expectedTitle=driver.getTitle();
        String actualTitle="YouTube";
        System.out.println(expectedTitle.equals(actualTitle)? "PASSED" : "FAILED");

        String expectedURL=driver.getCurrentUrl();
        String actualURL="https://www.youtube.com/";
        System.out.println(expectedURL.equals(actualURL)? "PASSED" : "FAILED");


        driver.navigate().to("file:///C:/Users/canku/Desktop/techtorial.html");
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);

        driver.manage().window().maximize();

        WebElement can = driver.findElement(By.id("techtorial1"));
        String actualHeader= can.getText().trim();
        String expectedHeader= "Techtorial Academy";
        System.out.println(actualHeader.equals(expectedHeader)? "PASSED" : "FAILED");

        driver.navigate().to("file:///C:/Users/canku/Desktop/techtorial.html");


        WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());

        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Emrah");

        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Can");

        WebElement JavaBox = driver.findElement(By.id("cond1"));
        if (!JavaBox.isSelected() && JavaBox.isDisplayed()) {
            JavaBox.click();

        }
        System.out.println(JavaBox.isSelected()? "SELECTED" : "NOT SELECTED");

WebElement drive = driver.findElement(By.partialLinkText("Rest"));
drive.click();
        System.out.println(drive.getText());



    }
}
