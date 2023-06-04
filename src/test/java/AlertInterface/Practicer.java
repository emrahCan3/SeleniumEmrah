package AlertInterface;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Practicer {

    @Test

    public void practiceJSAlert() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");


        WebElement alertBoxOK = driver.findElement(By.xpath("//button[@id='alertBox']"));
        alertBoxOK.click();
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText().trim();
        String expectedMessage = "I am an alert box!";
        Assert.assertEquals(actualMessage,expectedMessage);
        alert.accept();

        WebElement message1 = driver.findElement(By.xpath("//div[contains(text(),'popup')]"));
        Assert.assertEquals(BrowserUtils.getText(message1),"You selected alert popup");

        WebElement confirmBox = driver.findElement(By.cssSelector("#confirmBox"));
        confirmBox.click();
        alert.dismiss();
        WebElement message2 = driver.findElement(By.cssSelector("#output"));
        Assert.assertEquals(BrowserUtils.getText(message1),"You pressed Cancel in confirmation popup");

        WebElement promptBox = driver.findElement(By.cssSelector("#promptBox"));
        promptBox.click();
        Thread.sleep(2000);
        alert.sendKeys("Emrah");
        alert.accept();
        WebElement message3 = driver.findElement(By.cssSelector("#output"));
        Assert.assertEquals(BrowserUtils.getText(message1),"You entered text Emrah in propmt popup");




    }
}
