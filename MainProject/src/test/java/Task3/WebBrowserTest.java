package Task3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class WebBrowserTest {

    WebDriver driver;

    final String ACTUAL_TITLE = "Школа програмування : SoftServe провідна IT-компанія";
    final String ACTUAL_URL = "https://career.softserveinc.com/uk-ua/technology";
    final String NAME_OF_ELEMENT = "LC20lb";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        driver.manage().window().maximize();
        driver.get("https://google.com/");

        WebElement softServeElement =  driver.findElement(By.name("q"));
        softServeElement.sendKeys("softserve it academy");
        softServeElement.sendKeys(Keys.ENTER);

    }
    @Test(groups = "BrowserTest", enabled = false)
    public void testNameOfLink() {

        String name = driver.findElement(By.className(NAME_OF_ELEMENT)).getText();
        Assert.assertEquals(name, ACTUAL_TITLE);
    }
    @Test(groups = "BrowserTest", enabled = false)
    public void testUrl() {
        driver.findElement(By.className(NAME_OF_ELEMENT)).click();
        Assert.assertEquals(driver.getCurrentUrl(), ACTUAL_URL);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
