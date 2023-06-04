package SeleniumIntro;

import com.google.gson.internal.bind.util.ISO8601Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RealLifeExamplePractice {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("remote-allow-origins=*");
        //then create your driver to start automation

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.godaddy.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle ="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";
        System.out.println(expectedTitle.equals(actualTitle) ? "TITLE PASSED" : "TITLE FAILED");

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.godaddy.com/";
        System.out.println(actualUrl.equals(expectedUrl) ? "URL PASSED" : "URL FAILED");

driver.close();
    }

        }


    //  Test Case - Open Godaddy.com and validate it's Page title and the url.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/
//
//4. Get Title of page and validate it.(if conditions) expected title from website
//4. Get URL of current page and validate it.          expected url from website
//            5. Close browser.(driver.close)
