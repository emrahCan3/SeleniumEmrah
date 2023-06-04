package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
public class SelectPractice {


    @Test
    public void practice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize(); //it maximizes the screen
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///C:/Users/canku/Desktop/techtorial.html");
        WebElement selection = driver.findElement(By.name("country"));
        Select choice = new Select(selection);
        String actualFirstOption = choice.getFirstSelectedOption().getText().trim();
        String expectedFirstOption ="UNITED STATES";
        Assert.assertEquals(actualFirstOption,expectedFirstOption);

        List<WebElement> allCountries=choice.getOptions();
int counter = 0;
        for(WebElement cntry : allCountries) {
            System.out.println(cntry.getText().trim());
            counter++;
        }
        System.out.println(counter);


    }
}
