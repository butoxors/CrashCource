package Task4.PageFactory.Elements;

import org.openqa.selenium.WebElement;

public class SearchButton extends AbstractElement implements IButton{
    public SearchButton(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void click() {
        wrappedElement.click();
    }
}
