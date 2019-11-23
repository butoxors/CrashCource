package DataProviderTask.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleHomePage extends BasePage{
    @FindBy(xpath = "//input[@class='gNO89b' and @value='Поиск в Google']")
    private WebElement _searchBtn;

    private final String _homeUrl = "https://www.google.com/";

    public void goHome(){
        this.driver.get(_homeUrl);
    }

    public void typeQuery(String query){
        _searchField.sendKeys(query);
        _searchField.click();

        wait.until(ExpectedConditions.elementToBeClickable(_searchBtn));

        _searchBtn.click();
    }
}
