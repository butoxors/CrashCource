package Task4.PageFactory.Elements;

import org.openqa.selenium.WebElement;

public class AbstractElement implements IElement {
    protected final WebElement wrappedElement;

    public AbstractElement(final WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

    @Override
    public boolean isDisplayed() {
        return wrappedElement.isDisplayed();
    }

    @Override
    public WebElement getElement() {
        return wrappedElement;
    }
}
