package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.http.io.SessionOutputBuffer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import java.net.http.WebSocket;
import java.time.Duration;
import java.util.Set;

import static AhmetPractice.AhmetPractice.driver;

public class SwitchWindow {

    @Test
    public void switchPractice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement windows = driver.findElement(By.xpath("//a[.='Click Here']"));
        windows.click();
WebElement header= driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
        System.out.println(driver.getWindowHandle()); //main pageID - THE INTERNET
        String mainPageId = driver.getWindowHandle();
        Set<String> allPagesID =driver.getWindowHandles();
        for(String id:allPagesID) {
            if(!id.equals(mainPageId)) {
                driver.switchTo().window(id);
                break;
            }
        }
        System.out.println(allPagesID);
        header=driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
    }
    @Test
    public void practice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button2= driver.findElement(By.cssSelector("#newTabBtn"));
   button2.click();
        String mainPageId = driver.getWindowHandle();
        Set<String> allPagesID =driver.getWindowHandles();
        for(String id:allPagesID) {
            if(!id.equals(mainPageId)) {
                driver.switchTo().window(id);
                break;
            }}
   String actualTitle = driver.getTitle().trim();
   String expected= "AlertsDemo - H Y R Tutorials";
   Assert.assertEquals(actualTitle,expected);
   WebElement header=driver.findElement(By.xpath("//h1[@itemprop='name']"));
   String actualHeader=BrowserUtils.getText(header);
   String expectedHeader="AlertsDemo";
   Assert.assertEquals(actualHeader,expectedHeader);
   WebElement alertbox=driver.findElement(By.cssSelector("#alertBox"));
   alertbox.click();



    }
}

