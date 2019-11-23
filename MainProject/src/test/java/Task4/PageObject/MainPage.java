package Task4.PageObject;

import Task4.PageFactory.Elements.SearchButton;
import Task4.PageFactory.ExtendedFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends APage {

    @FindBy(xpath = "//img[@class='inverted' and @alt='Search']")
    private SearchButton searchIcon;

    public void goToSearch(){
        //wait(searchIcon.getElement());
        waitOverlay();
        searchIcon.click();
    }

    @Override
    public void init(final WebDriver webDriver) {
        wait = new WebDriverWait(webDriver, 3);
        PageFactory.initElements(new ExtendedFieldDecorator(webDriver), this);
    }

}
