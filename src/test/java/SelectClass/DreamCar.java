package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class DreamCar {

    @Test
    public void HeadersOfTheCar() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.cars.com/");

        WebElement newUsedOption = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
BrowserUtils.selectBy(newUsedOption, "new", "value");
        Thread.sleep(2000);
        WebElement make = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(make, "Lexus", "text");
        Thread.sleep(2000);
        WebElement model = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(model, "lexus-rx_350", "value");
        Thread.sleep(2000);
        WebElement price = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select priceDefault = new Select(price);
        String actualPrice = BrowserUtils.getText(priceDefault.getFirstSelectedOption());
        String expectedPrice = "No max price";
        Assert.assertEquals(actualPrice, expectedPrice);

        Thread.sleep(2000);

        WebElement mile = driver.findElement(By.id("make-model-maximum-distance"));
        BrowserUtils.selectBy(mile, "40 miles", "text");

        Thread.sleep(2000);

        WebElement zipc = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipc.clear();
        zipc.sendKeys("60056");
        Thread.sleep(2000);

        WebElement button = driver.findElement(By.xpath("//button[@data-linkname='search-new-make']"));
        button.click();

        Thread.sleep(2000);

        WebElement header = driver.findElement(By.xpath("//h1[@data-qa='page_h1']"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="New Lexus RX 350 for sale";
        Assert.assertEquals(actualHeader,expectedHeader);

        WebElement sort = driver.findElement(By.cssSelector("#sort-dropdown"));

        Thread.sleep(2000);

        BrowserUtils.selectBy(sort, "Lowest price", "text");

        Thread.sleep(2000);

        List<WebElement> allTitles = driver.findElements(By.xpath("//h2[@class='title']"));

        for (WebElement title : allTitles) {
            Assert.assertTrue(BrowserUtils.getText(title).contains("Lexus RX 350"));
            System.out.println(BrowserUtils.getText(title));

        }

List<WebElement> allPrices = driver.findElements(By.cssSelector(".primary-price"));
        List<String> actualPrices = new ArrayList<>();
        List<String> expectedPrices = new ArrayList<>();

        for (int i=0; i < allPrices.size();i++) {
            actualPrices.add(BrowserUtils.getText(allPrices.get(i)).replace("$","" ).replace(",",""));
            expectedPrices.add(BrowserUtils.getText(allPrices.get(i)).replace("$","").replace(",", ""));

        }

        Collections.sort(expectedPrices);
        Assert.assertEquals(actualPrices,expectedPrices);
        System.out.println(actualPrices);
        System.out.println(expectedPrices);



          /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
     */



        }
    }
