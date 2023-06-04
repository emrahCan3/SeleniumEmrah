package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class DriverFindElementsPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/"); //url

        List<WebElement> allLinks = driver.findElements(By.xpath("//li"));
        int count =0;
        for (WebElement link:allLinks) {
            System.out.println(link.getText());
            count++;

        }
        System.out.println(count);
        System.out.println(allLinks.size());

        int count2=0;
        for (WebElement link:allLinks) {
            if(link.getText().length() >=12) {
                System.out.println(link.getText().trim());
                count2++;
            }
        }
        System.out.println(count2);

        //TASK2
                //Print it if length is equal and more than 12 and count how many
    }
}
