package Task4.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface IPage {
    void init(WebDriver webDriver);
    void wait(WebElement element);
}
