package DataProviderTask.TestCases;

import DataProviderTask.DataProviders;
import DataProviderTask.DriverFactory.DriverFactory;
import DataProviderTask.DriverFactory.DriverType;
import DataProviderTask.PageObject.GoogleHomePage;
import DataProviderTask.PageObject.GoogleSearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Task1 {

    private GoogleHomePage _googleHomePage;
    private GoogleSearchPage _googleSearchPage;
    private WebDriver _driver;

    @Test(dataProvider = "getOptions", dataProviderClass = DataProviders.class)
    public void runCase(DriverType type, String query) {
        _driver = DriverFactory.getDriver(type);

        _googleHomePage = new GoogleHomePage();
        _googleHomePage.init(_driver);
        _googleHomePage.goHome();
        _googleHomePage.typeQuery(query);

        _googleSearchPage = new GoogleSearchPage();
        _googleSearchPage.init(_driver);
        int countOfResults = _googleSearchPage.checkCountQueries(query);

        Assert.assertTrue(countOfResults > 0);
        System.out.println("Has been found " + countOfResults + " of results");
    }
    @AfterMethod
    public final void tearDown(){
        _driver.quit();
    }
}
