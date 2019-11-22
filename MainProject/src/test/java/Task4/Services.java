package Task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class Services extends BaseTest{

    private List<String> serviceList;
    private List<WebElement> serviceElements;

    @BeforeSuite
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        serviceList = new ArrayList<String>();
        serviceList.add("Програмне забезпечення");
        serviceList.add("Хмарні технології");
        serviceList.add("Великі дані");
        serviceList.add("Штучний інтелект");
        serviceList.add("Інтернет речей (IoT)");
        serviceList.add("Сервісний дизайн");
        serviceList.add("Кібербезпека");
        serviceList.add("Цифрові платформи");
        serviceList.add("Розширена реальність (XR)");
    }

    @Test(priority = 0,
            groups = {"serviceTest"})
    public void getServices() {
        serviceElements = driver.findElements(By.className("services-nav-link"));
    }

    @Test(priority = 1,
            groups = {"serviceTest"},
            dependsOnMethods = "getServices")
    public void numberOfServices() {

        if (serviceElements != null) {
            Assert.assertEquals(serviceElements.size(), serviceList.size());
        }else {
            System.out.println("Error - Can't find any of service!");
        }
    }

    @Test(priority = 1,
            groups = {"serviceTest"},
            dependsOnMethods = "getServices")
    public void serviceComparison() {
        List<String> expected = new ArrayList<String>();

        serviceList.replaceAll(x -> x.toUpperCase());

        for (WebElement webElement : serviceElements) {
            expected.add(webElement.getText());
        }

        Assert.assertEquals(serviceList, expected);
    }

    /*@AfterClass
    public void tearDown() {
        driver.quit();
    }*/
}
