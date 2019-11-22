package Task4.PageFactory.Containers;

import Task4.PageFactory.Elements.IElement;
import org.openqa.selenium.WebElement;

public interface IContainer extends IElement {
    void init(WebElement webElement);
}
