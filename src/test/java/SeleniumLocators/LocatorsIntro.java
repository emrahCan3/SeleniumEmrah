package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.http.io.SessionOutputBuffer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro {
    //LOCATORS -- is a way to locate(find) element and manipulate on it
    public static void main(String[] args) throws InterruptedException {

        //ID LOCATOR:
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver= new ChromeDriver(options);
        driver.navigate().to("file:///C:/Users/canku/Desktop/techtorial.html");
        driver.manage().window().maximize();
        WebElement header=driver.findElement(By.id("techtorial1"));   //to find the element with driver
        String actualHeader=header.getText().trim(); //it gets the text from element
        String expectedHeader="Techtorial Academy";
        System.out.println(header.getText());
        System.out.println(actualHeader.equals(expectedHeader) ? "CORRECT" : "WRONG");

        WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());


        //NAME LOCATOR

        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Emrah");

        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Can");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("24235");

        WebElement email = driver.findElement(By.name("userName"));
        email.sendKeys("emrahcan3@hotmail.com");

        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("4087 FAIRWAY LAKES DR");

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Myrtle Beach");

        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("SC");

        WebElement postalCode = driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("29577");

        //CLASS LOCATOR

        WebElement allTools = driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());

        WebElement javaBox = driver.findElement(By.id("cond1"));
        if(javaBox.isDisplayed() && javaBox.isSelected()) {
            javaBox.click();
        }
        System.out.println(javaBox.isSelected()? "SELECTED" : "NOT SELECTED" );


        WebElement TestNgBox = driver.findElement(By.id("cond3"));
        if(TestNgBox.isDisplayed() && !TestNgBox.isSelected()) {
            TestNgBox.click();
        }
        System.out.println(TestNgBox.isSelected()? "SELECTED" : "NOT SELECTED" );

        //TAGNAME LOCATOR:

        WebElement header2=driver.findElement(By.tagName("u"));
        System.out.println(header2.getText());

        Thread.sleep(2000);
        driver.quit();
    }




}
