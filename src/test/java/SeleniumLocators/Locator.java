package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Locator {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement makeAppointment = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));

        makeAppointment.click();
        Thread.sleep(2000);
        WebElement name = driver.findElement(By.xpath("//input[@name='username']"));
        name.sendKeys("John Doe");
        Thread.sleep(2000);
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("ThisIsNotAPassword");
        Thread.sleep(2000);
        WebElement login = driver.findElement(By.xpath("//button[@id='btn-login']"));
        login.click();
        Thread.sleep(2000);
        WebElement facility = driver.findElement(By.xpath("//option[@value='Hongkong CURA Healthcare Center']"));
        facility.click();
        Thread.sleep(2000);
        WebElement readmission = driver.findElement(By.xpath("//label[@for='chk_hospotal_readmission']"));
        if(readmission.isDisplayed() && !readmission.isSelected()) {
        readmission.click(); }
        Thread.sleep(2000);
        WebElement medicaid = driver.findElement(By.xpath("//input[@value='Medicaid']"));
        medicaid.click();
        Thread.sleep(2000);
        WebElement date = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        date.sendKeys("05/17/2023");
        Thread.sleep(2000);
        WebElement comment = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        comment.sendKeys("no comment");
        Thread.sleep(2000);
        WebElement bookAppointment = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        bookAppointment.click();


        WebElement title = driver.findElement(By.xpath("//h2[.='Appointment Confirmation']"));
        System.out.println(title.getText());

        WebElement one = driver.findElement(By.xpath("//p[.='Hongkong CURA Healthcare Center']"));
        System.out.println(one.getText());

        WebElement two = driver.findElement(By.xpath("//p[.='Yes']"));
        System.out.println(two.getText());

        WebElement three = driver.findElement(By.xpath("//p[.='Medicaid']"));
        System.out.println(three.getText());

        WebElement four = driver.findElement(By.xpath("//p[.='07/09/2020']"));
        System.out.println(four.getText());

        WebElement five = driver.findElement(By.xpath("//p[.='i am happy that i have insurance lol']"));
        System.out.println(five.getText());

        WebElement goToHomePage = driver.findElement(By.xpath("//p[.='Go to Homepage']"));
        goToHomePage.click();

        String actualUrl = driver.getCurrentUrl();
        String exceptedUrl = "https://katalon-demo-cura.herokuapp.com/";

        System.out.println(driver.getCurrentUrl().equals(exceptedUrl) ? "PASSES" : "FAILED");
    }}