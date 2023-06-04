package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("file:///C:/Users/canku/Desktop/techtorial.html");


        //LINKTEXT LOCATOR

        WebElement javalink=driver.findElement(By.linkText("Java"));
        javalink.click();
        WebElement javaHeader=driver.findElement(By.tagName("h1"));
        String actualHeader=javaHeader.getText().trim();
        String expectedHeader="Java";
        System.out.println(actualHeader.equals(expectedHeader)? "CORRECT" : "FALSE");


        /* /*
1-Click Selenium and validate(ternary) header -->Selenium automates browsers. That's it!
2-Go back to the main page
3-Click Cucumber and validate(ternary) header -->Tools & techniques that elevate teams to greatness
4-Go back to the main page
5-Click TestNG and validate(ternary) header -->TestNG
6-Go back to the main page
7-Validate(ternary) the url is "file:///Users/codefish/Downloads/Techtorial.html"
 */
        driver.navigate().back();   //nagivates to back page
        WebElement selenium=driver.findElement(By.linkText("Selenium")); //it has a tagname and text
        selenium.click();
        WebElement seleniumHeader=driver.findElement(By.tagName("h1"));
        String actualSeleniumHeader=seleniumHeader.getText().trim(); //find the element
        String expectedSeleniumHeader="Selenium automates browsers";
        System.out.println(actualSeleniumHeader.equals(expectedSeleniumHeader)? "Passed SELENIUM" : "Failed SELENIUM");

        driver.navigate().back();

        WebElement testNGlink=driver.findElement(By.linkText("TestNG"));
        testNGlink.click();
        WebElement headerTestNG=driver.findElement(By.tagName("h2"));
        System.out.println(headerTestNG.getText());

        driver.navigate().back();
        String actualUrl=driver.getCurrentUrl();
        String expecctedUrl = "file:///C:/Users/canku/Desktop/techtorial.html";
        System.out.println(actualUrl.equals(expecctedUrl) ? "PASSED" : "FAILED");



        //LOCATOR PARTIAL LINKTEXT:

        WebElement restApi = driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getTitle());



    }
}
