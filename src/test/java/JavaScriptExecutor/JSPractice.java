package JavaScriptExecutor;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class JSPractice {
@Test
    public void clickJS() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");
        WebElement RadioButton = driver.findElement(By.cssSelector("#yesRadio"));
        RadioButton.isSelected();
        //Actions actions = new Actions(driver);09+\==
        //actions.click()==00

        WebElement message= driver.findElement(By.xpath("//p[@class='mt-3']"));

        String actualMessage = BrowserUtils.getText(message);
        String expectedMessage = "You have selected Yes";
        Assert.assertEquals(actualMessage,expectedMessage);
        WebElement noRadioButton = driver.findElement(By.cssSelector("#noRadio"));
        Assert.assertFalse(noRadioButton.isEnabled());


}}
