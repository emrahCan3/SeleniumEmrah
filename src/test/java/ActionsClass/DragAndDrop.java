

  package ActionsClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

    public class DragAndDrop {
        @Test
        public void DragAndDrop() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

            WebElement orangeBox2 = driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
            String actualMessage = BrowserUtils.getText(orangeBox2);
            String expectedMessage= "... Or here.";
            Assert.assertEquals(actualMessage, expectedMessage);

            String actualBackgroundColor = orangeBox2.getCssValue("background-color");//looks for the background color
            String expectedBackgroundColor = "rgba(238, 111, 11, 1)";//if we leave it empty we'll get an exception. 1st leave it empty.run it then copy+paste.
            Assert.assertEquals(actualBackgroundColor, expectedBackgroundColor); //we validate the background color.

            WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
            Thread.sleep(3000);
            Actions action = new Actions(driver);
            action.dragAndDrop(draggable, orangeBox2).perform();
            Thread.sleep(2000);
            orangeBox2 = driver.findElement(By.xpath("//div[@class='test2']"));
            String actualAfterDragDrop = BrowserUtils.getText(orangeBox2);
            String expectedAfterDragDrop = "You did great!";
            Assert.assertEquals(actualAfterDragDrop, expectedAfterDragDrop);

        }

        @Test
        public void DragAndDropPractice1() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

            WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
            String actualMessage = BrowserUtils.getText(blueBox);
            String expectedMessage = "Drag the small circle here ...";
            Assert.assertEquals(actualMessage, expectedMessage);

            String actualColor = blueBox.getCssValue("background-color").trim();
            String expectedColor = "rgba(63, 81, 181, 1)";
            Assert.assertEquals(actualColor, expectedColor);

            WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
            Actions action = new Actions(driver);

            action.clickAndHold(draggable).moveToElement(blueBox).release().perform();
            blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
            String actualMessageAfter = BrowserUtils.getText(blueBox);
            String expectedMessageAfter = "You did great!";
            Assert.assertEquals(actualMessageAfter, expectedMessageAfter);





    }


        @Test
        public void ClickAndHold() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://demoqa.com/droppable");
            WebElement acceptButton=driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
                    acceptButton.click();
            Thread.sleep(3000);
            WebElement notAcceptButton= driver.findElement(By.cssSelector("#notAcceptable"));
            String actualText= BrowserUtils.getText(notAcceptButton);
            String expectedText="Not Acceptable";
            Assert.assertEquals(actualText,expectedText);
            Thread.sleep(2000);
            WebElement box= driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
            String actualMessage=BrowserUtils.getText(box);
            String expectedMessage="Drop here";
            Assert.assertEquals(actualMessage,expectedMessage);
Actions actions = new Actions(driver);
actions.clickAndHold(notAcceptButton).moveToElement(box).release().perform();
           String actualMessageAfterAction=BrowserUtils.getText(box);
           String expectedMessageAfterAction="Drop here";
           Assert.assertEquals(actualMessageAfterAction,expectedMessageAfterAction);



        }


    }






