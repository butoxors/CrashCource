package DataProviderTask.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage implements IPage{
    @FindBy(xpath = "//input[@name='q']")
    protected WebElement _searchField;

    protected WebDriver driver;
    protected WebDriverWait wait;

    public void init(WebDriver driver){
        PageFactory.initElements(driver, this);

        this.driver = driver;
        this.driver.manage().window().maximize();

        wait = new WebDriverWait(this.driver, 3);
    }

}
