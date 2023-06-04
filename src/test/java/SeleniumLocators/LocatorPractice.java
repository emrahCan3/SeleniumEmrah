package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver((chromeOptions));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");



        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys("Emrah");

        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys("Can");

        WebElement gender = driver.findElement(By.id("sex-0"));
        gender.click();

        WebElement experience = driver.findElement(By.id("exp-4"));
        experience.click();

        WebElement date = driver.findElement(By.id("datepicker"));
        date.sendKeys("05/16/2023");

        WebElement manTest = driver.findElement(By.id("profession-0"));
        manTest.click();

        WebElement autTest = driver.findElement(By.id("profession-1"));
        autTest.click();

        WebElement tools = driver.findElement(By.id("tool-2"));
        tools.click();

        WebElement continent = driver.findElement(By.id("continents"));
        continent.sendKeys("Asia");

        WebElement submit=driver.findElement(By.name("submit"));
        submit.click();

        Thread.sleep(2000);
        driver.quit();

        String actualUrl = driver.getCurrentUrl();
        String expUrl = "https://www.techlistic.com/p/selenium-practice-form.html";
        System.out.println(actualUrl.equals(expUrl)?"URL PASSED":"URL FAILED");




         /*
1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox). -->choose Both
7-Select Automation tools you are familiar with (multiple checkboxes). --> Choose Selenium
8-Select Continent(Send Keys).
9-Click on Submit button.
10-Validate the url https://www.techlistic.com/p/selenium-practice-form.html
10-Close the webpage
Try your own logic and automate it without any help.
     */

    }
}
