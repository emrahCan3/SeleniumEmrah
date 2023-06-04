import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.sdk.metrics.internal.view.ViewRegistry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;

public class HomeWork {
    @Test
    public void TestScenario() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Web Orders Login";
        System.out.println(actualTitle.equals(expectedTitle) ? "PASSED" : "FAILED");
        WebElement UserName = driver.findElement(By.name("ctl00$MainContent$username"));
        UserName.sendKeys("Tester");
        Thread.sleep(1000);
        WebElement Password = driver.findElement(By.name("ctl00$MainContent$password"));
        Password.sendKeys("test");
        Thread.sleep(1000);
        WebElement login = driver.findElement(By.name("ctl00$MainContent$login_button"));
        login.click();

        WebElement Title = driver.findElement(By.tagName("h1"));
        String actualTitle1 = BrowserUtils.getText(Title);
        String expectedTitle1 = "Web Orders";
        Assert.assertEquals(actualTitle1, expectedTitle1);

        WebElement Header = driver.findElement(By.tagName("h2"));
        String actualHeader = BrowserUtils.getText(Header);
        String expectedHeader = "List of All Orders";
        Assert.assertEquals(actualHeader, expectedHeader);


    }

    @Test
    public void TestScenario2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement UserName = driver.findElement(By.name("ctl00$MainContent$username"));
        UserName.sendKeys("Tester");
        Thread.sleep(1000);
        WebElement Password = driver.findElement(By.name("ctl00$MainContent$password"));
        Password.sendKeys("test");
        Thread.sleep(1000);
        WebElement login = driver.findElement(By.name("ctl00$MainContent$login_button"));
        login.click();

        BrowserUtils.switchByTitle(driver, "Web Orders");
        WebElement allProducts = driver.findElement(By.xpath("//a[contains(text(), 'View all products')]"));
        allProducts.click();

        BrowserUtils.switchByTitle(driver, "View all products");
        WebElement header = driver.findElement(By.tagName("h2"));
        Assert.assertEquals(BrowserUtils.getText(header), "List of Products");


        Assert.assertTrue(driver.getCurrentUrl().contains("Products"));


    }

    @Test
    public void TestScenario3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement UserName = driver.findElement(By.name("ctl00$MainContent$username"));
        UserName.sendKeys("Tester");
        Thread.sleep(1000);
        WebElement Password = driver.findElement(By.name("ctl00$MainContent$password"));
        Password.sendKeys("test");
        Thread.sleep(1000);
        WebElement login = driver.findElement(By.name("ctl00$MainContent$login_button"));
        login.click();

        WebElement viewAllOrders = driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        String actualViewOrder = viewAllOrders.getAttribute("href");
        Assert.assertTrue(actualViewOrder.contains("Default.aspx"));
        Thread.sleep(2000);
        WebElement ViewAllProducts = driver.findElement(By.xpath("//a[@href='Products.aspx']"));
        String actualViewAllProducts = ViewAllProducts.getAttribute("href");
        Assert.assertTrue(actualViewAllProducts.contains("Products.aspx"));
        Thread.sleep(2000);
        WebElement Orders = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        String actualOrders = Orders.getAttribute("href");
        Assert.assertTrue(actualOrders.contains("Process.aspx"));
    }
    @Test
    public void TestScenario4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement UserName = driver.findElement(By.name("ctl00$MainContent$username"));
        UserName.sendKeys("Tester");
        Thread.sleep(1000);
        WebElement Password = driver.findElement(By.name("ctl00$MainContent$password"));
        Password.sendKeys("test");
        Thread.sleep(1000);
        WebElement login = driver.findElement(By.name("ctl00$MainContent$login_button"));
        login.click();
        BrowserUtils.switchByTitle(driver,"Web Orders");
        WebElement Orders = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        Orders.click();
        WebElement Product = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
        Select select = new Select(Product);
        select.selectByVisibleText("ScreenSaver");
        Thread.sleep(1000);
        WebElement Qau = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        Qau.sendKeys("6");

        
        WebElement CustomerName = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        CustomerName.sendKeys("CodeFish IT School");
        Thread.sleep(1000);

        WebElement Street = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        Street.sendKeys("2200 E devon");
        Thread.sleep(1000);
        WebElement City = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        City.sendKeys("Des Plaines");
        Thread.sleep(1000);
        WebElement State = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        State.sendKeys("IlIionis");
        Thread.sleep(1000);
        WebElement Zip = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        Zip.sendKeys("60018");
        Thread.sleep(1000);
        WebElement CardType = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_1"));
        CardType.click();
        Thread.sleep(1000);
        WebElement Input = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        Input.sendKeys("444993876233");
        Thread.sleep(1000);
        WebElement Expiration = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        Expiration.sendKeys("03/24");
        Thread.sleep(1000);
        WebElement Button = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_InsertButton"));
        Button.click();

        WebElement text = driver.findElement(By.xpath("//strong"));
        String actualText = BrowserUtils.getText(text);
        String expectedText = "New order has been successfully added.";
        Assert.assertEquals(actualText, expectedText);
        Assert.assertTrue(text.isDisplayed());

        WebElement ViewAllOrders = driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        ViewAllOrders.click();

        BrowserUtils.switchByTitle(driver, "View all orders");
        WebElement newOrder = driver.findElement(By.xpath("//tr//td//td[.='CodeFish IT School']"));
       String NewOrderExpected = "CodeFish IT School";
       Assert.assertEquals(newOrder.getText(),NewOrderExpected);

}}