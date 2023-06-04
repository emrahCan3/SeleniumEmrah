package AhmetPractice;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.net.http.WebSocket;

public class EmrahPractice extends  AhmetPractice{

    public static void main(String[] args) throws InterruptedException {

        String url = "https://demo.guru99.com/test/simple_context_menu.html";

        String browser = "chrome";

        openBrowserAndLaunchApplication(url,browser);
WebElement rightClick = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));


Actions action = new Actions(driver);

action.contextClick(rightClick).perform();

driver.quit();

    }
@Test
    public class EmrahPractice2 extends  AhmetPractice{

        public static void main(String[] args) throws InterruptedException {

            String url = "https://demo.guru99.com/test/simple_context_menu.html";

            String browser = "chrome";

            openBrowserAndLaunchApplication(url,browser);

            WebElement doubleClick = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));

            Actions action = new Actions(driver);
            action.doubleClick(doubleClick).perform();
}



    }}
