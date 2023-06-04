package FrameAndIframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class FramePractice {

    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(header.getText()); //or BrowserUtils.getText(header)
        driver.switchTo().frame("mce_0_ifr");
        WebElement box = driver.findElement(By.cssSelector("#tinymce"));
        box.clear();
        box.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
    }

    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");

        WebElement pavilion = driver.findElement(By.linkText("Pavilion"));
        pavilion.click();
        BrowserUtils.switchByTitle(driver, "qavalidation");
        WebElement seleniumButton = driver.findElement(By.xpath("//span[.='Selenium']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(seleniumButton).perform();

        WebElement javaPython = driver.findElement(By.linkText("Selenium-Python"));
        actions.click(javaPython).perform();

        WebElement header = driver.findElement(By.tagName("h1"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "Selenium-Python Tutorial";
        Assert.assertEquals(actualHeader, expectedHeader);
        List<WebElement> allLinks = driver.findElements(By.xpath("//p//a"));
Thread.sleep(2000);
        for (WebElement link1 : allLinks) {
            System.out.println(BrowserUtils.getText(link1));

            BrowserUtils.switchByTitle(driver,"iframes");
            driver.switchTo().frame("Framename1");
            WebElement category1= driver.findElement(By.linkText("Category1"));
            category1.click();
            BrowserUtils.switchByTitle(driver,"SeleniumTesting");
            WebElement headerCategory1 = driver.findElement(By.xpath("//h1"));
            String actualHeaderCategory= BrowserUtils.getText(headerCategory1);
            String expectedHeaderCategory= "Category Archives: SeleniumTesting";
            Assert.assertEquals(actualHeaderCategory,expectedHeaderCategory);
            Thread.sleep(2000);
            List<WebElement> list1= driver.findElements(By.xpath("//h3[@class='entry-title']"));
            for (WebElement headers :list1) {
                System.out.println(BrowserUtils.getText(headers));


            ///*
            //TASK 1:
            //  1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
            //  2-Click pavilion (new tab will be opened, consider switch window)
            //  3-Choose "Selenium-Phyton" from Selenium button (Action class is suggested)
            //  4-Validate the Header "Selenium-Python Tutorial"
            //  5-Print out(NO validation) all the links from website
            //  6-Wait for Second task
            // */
        }

/*
TASK 2:
1-Go back to the main page "iframe"
2-click category 1
3-Validate the header "Category Archives: SeleniumTesting"
4-Print out all the headers of the contents(i will show you)
 */





            }
        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame1");
        WebElement text1 = driver.findElement(By.cssSelector("#frametext"));
        System.out.println(BrowserUtils.getText(text1));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("Frame2");
        WebElement click2 = driver.findElement(By.xpath("//a[.='Category3']"));
        click2.click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives - qavalidation");
        WebElement title3 = driver.findElement(By.tagName("h1"));
        System.out.println(title3);
    }}


/*
TASK 2:
1-Go back to the main page "iframe"
2-click category 1
3-Validate the header "Category Archives: SeleniumTesting"
4-Print out all the headers of the contents(i will show you)
 */

/*
TASK 3:
1-Go back mainPage
2-print out I am inside Frame under category1
3-Click Category3
4-Print out the header
 */