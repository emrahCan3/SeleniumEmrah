package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class GetAttributePractice2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com/");
        //Thread.sleep(2000)
        //song.sendKeys(Keys.ARROW_DOWN) -- put this inside the loop
        WebElement searchBieber = driver.findElement(By.xpath("//input[@name='search_query']"));
        searchBieber.sendKeys("Eli & Fur");
        searchBieber.sendKeys(Keys.ENTER);

        List<WebElement> song = driver.findElements(By.xpath("//a[@id='video-title']"));
         Thread.sleep(2000);
                for (WebElement songs:song){

                    if (songs.getAttribute("aria-label").contains("Eli & Fur - You're So High (Music Video)")){
                        Thread.sleep(500);
                        songs.sendKeys(Keys.ARROW_DOWN);
                        songs.click();
                        break;
                    }
            }}


        }

