package Task4;

import Task4.PageObject.MainPage;
import Task4.PageObject.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    private final String URL = "https://www.softserveinc.com/uk-ua/";
    protected WebDriver driver;

    protected MainPage mainPage;
    protected SearchPage searchPage;

    @BeforeSuite(groups = {"searchTest serviceTest"})
    public void profileSetup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        driver = new ChromeDriver();

        mainPage = new MainPage();
        mainPage.init(driver);

        searchPage = new SearchPage();
        searchPage.init(driver);

        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterClass(groups = {"searchTest serviceTest"})
    public final void tearDown() {
        driver.quit();
    }
}
