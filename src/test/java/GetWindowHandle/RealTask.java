package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class RealTask {
    @Test
    public void practice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize(); //it maximizes the screen
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
                  /*
1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
2-Click open multiple tabs under Button 4
3-the Basic Control and fill all the blanks
4-Click Register button and validate the message "Registration is Successful"
5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
6- go to the alertsDemo page and click  the "Click Me" button under prompt box
7-quit all the pages.
8-Proud of yourself
 */


        WebElement button = driver.findElement(By.cssSelector("#newTabsBtn"));
        BrowserUtils.scrollWithJS(driver, button);
        button.click();

        BrowserUtils.switchByTitle(driver, "Basic");
        WebElement firstName = driver.findElement(By.cssSelector("#firstName"));
        firstName.sendKeys("Melek");
        WebElement lastName = driver.findElement(By.cssSelector("#lastName"));
        lastName.sendKeys("kokal");
        WebElement gender = driver.findElement(By.cssSelector("#femalerb"));
        BrowserUtils.scrollWithJS(driver, gender);
        gender.click();
        WebElement language = driver.findElement(By.cssSelector("#englishchbx"));
        language.click();
        WebElement email = driver.findElement(By.cssSelector("#email"));
        email.sendKeys("melek@gmail.com");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("melek123");
        WebElement registerButton = driver.findElement(By.cssSelector("#registerbtn"));

        registerButton.click();
        String mainPageId = driver.getWindowHandle();
        Set<String> allPagesID =driver.getWindowHandles();
        for(String id:allPagesID) {
            if(!id.equals(mainPageId)) {
                driver.switchTo().window(id);
                break;
            }}
        WebElement message = driver.findElement(By.cssSelector("#msg"));
        String actualMessage = driver.getTitle();
        String expectedMessage = "Registration is Successful";
        Assert.assertEquals(actualMessage, expectedMessage);

        BrowserUtils.switchByTitle(driver, "Window");
        String actualTitleofWindowHandle = driver.getTitle();
        String expectedTitle = "Window Handles Practice";
        Assert.assertEquals(actualTitleofWindowHandle, expectedTitle);

        BrowserUtils.switchByTitle(driver, "AlertsDemo");
        WebElement promptBoxButton = driver.findElement(By.cssSelector("#promptBox"));
        promptBoxButton.click();

        driver.quit();
    }}