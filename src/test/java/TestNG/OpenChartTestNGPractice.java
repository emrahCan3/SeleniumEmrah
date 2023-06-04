package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class OpenChartTestNGPractice {

    @Test
    public void succesfulLogin() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.tagName("button"));
        login.click();
        Thread.sleep(2000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle);

    }

@Test
public void negativeLoginTest() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    WebDriver driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.navigate().to("https://demo.opencart.com/admin/");
    WebElement username = driver.findElement(By.cssSelector("#input-username"));
    username.sendKeys("demo");
    WebElement password = driver.findElement(By.cssSelector("#input-password"));
    password.sendKeys("DEMO");
    WebElement login = driver.findElement(By.tagName("button"));
    login.click();
    Thread.sleep(2000);
    WebElement errorMessage = driver.findElement(By.cssSelector("#alert"));
    String actualMessage = errorMessage.getText().trim();
    String expectedMessage = "No match for Username and/or Password.";
    Assert.assertEquals(actualMessage, expectedMessage);
}
@Test
        public void validateProductButton() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    WebDriver driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.navigate().to("https://demo.opencart.com/admin/");
    WebElement username = driver.findElement(By.cssSelector("#input-username"));
    username.sendKeys("demo");
    WebElement password = driver.findElement(By.cssSelector("#input-password"));
    password.sendKeys("demo");
    WebElement login = driver.findElement(By.tagName("button"));
    login.click();
    Thread.sleep(2000);
    WebElement button = driver.findElement(By.cssSelector(".btn-close"));
    button.click();
    WebElement catalogButton = driver.findElement(By.xpath("//a[contains(text(), 'Catalog,)]"));
    catalogButton.click();
    WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));
    Assert.assertTrue(productsButton.isDisplayed());
    Assert.assertTrue(productsButton.isEnabled());




    }
    @Test
    public void validateBoxesFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.tagName("button"));
        login.click();
        Thread.sleep(2000);
        WebElement button = driver.findElement(By.cssSelector(".btn-close"));
        button.click();
        WebElement catalogButton = driver.findElement(By.xpath("//a[contains(text(), 'Catalog,)]"));
        catalogButton.click();
        WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));
        productsButton.click();
        Thread.sleep(1000);
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input']"));
        for (int i = 1; i <= checkboxes.size(); i++){
            Thread.sleep(1000);
            Assert.assertTrue(checkboxes.get(i).isDisplayed());
            Assert.assertTrue(checkboxes.get(i).isEnabled());
            Assert.assertFalse(checkboxes.get(i).isSelected()); //as default it shouldnt be selected
            checkboxes.get(i).click();
            Assert.assertTrue(checkboxes.get(i).isSelected()); //it should be selected
            checkboxes.get(i).sendKeys(Keys.ARROW_DOWN);

        }
        /*STEPS:
        1-Find the all boxes location
        2-use regular for loop and start from 1(int i=1
        3-inside of loop u should have:
        1-Thread.sleep
        2-IsDisplayed(True)
        3-IsEnabled(true)
        4-IsSelected(false) --AssertFalse
        5-Click
        6-IsSelected(true) --AssertTrue
        7-box.sendKeys(Keys.Arrow_Down
         */
    }
}
/*
TEST CASE:

1-You will click the productName button
2-You should create 2 arraylist
  *-One of them will be actualData
  *-Another will be expectedData
3-For(int i=1)
  *store all the names for both of the list.Please use at the end .toUpperCase or toLowerCase
4-For expected List -->you will use Collections.sort(expectedList)
                    -->Collections.reverse(expected)
                    Assert.equals(actualList,expectedlist)
 */