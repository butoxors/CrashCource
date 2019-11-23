package Task4.PageFactory.Containers;

import org.openqa.selenium.WebElement;

public abstract class AContainer implements IContainer{
    private WebElement webElement;

    @Override
    public void init(final WebElement webElement) {
        this.webElement = webElement;
    }

    @Override
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    @Override
    public WebElement getElement() {
        return webElement;
    }
}
