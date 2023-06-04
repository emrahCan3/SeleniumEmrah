package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumBasics {


    //FIRST STEP is setting up your automation

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("remote-allow-origins=*");
        //then create your driver to start automation

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());
        String actualTitle= driver.getTitle();

        String expectedTitle="Amazon.com. Spend less. Smile more";
        if(actualTitle.equals(expectedTitle)) {
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }

String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.amazon.com/";
        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Passed");
        }else {
            System.out.println("failed");

    }

        driver.close();

    }
}
