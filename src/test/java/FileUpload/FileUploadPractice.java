package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadPractice {

    @Test
    public void practice1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("C:\\Users\\canku\\Desktop\\usa.png");
        WebElement uploadButton = driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.submit(); //uploadButton.click()
        WebElement ActualvalidateFileName= driver.findElement(By.cssSelector("#uploaded-files"));
        String actualName=BrowserUtils.getText(ActualvalidateFileName);
        String expectedName = "usa.png";
        Assert.assertEquals(actualName,expectedName);

    }
    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement  UploadFile = driver.findElement(By.cssSelector("#uploadfile_0"));
        UploadFile.sendKeys("C:\\Users\\canku\\Desktop\\usa.png");
        WebElement Validate = driver.findElement(By.xpath("//b[contains(text(),'Select file to send')]"));
        String actualName = BrowserUtils.getText(Validate);
        String expectedName= "Select file to send(max 196.45 MB)";
        Assert.assertEquals(actualName,expectedName);

        WebElement clickBox = driver.findElement(By.xpath("//input[@id='terms']"));
        clickBox.click();
        Thread.sleep(2000);
        WebElement SubmitButton = driver.findElement(By.cssSelector("#submitbutton"));
                SubmitButton.click();

Thread.sleep(2000);
        WebElement message= driver.findElement(By.tagName("h3"));
        Assert.assertEquals(BrowserUtils.getText(message), "1 file\n" +
                "has been successfully uploaded.");


}}
