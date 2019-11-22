package Task4.PageFactory.Elements;

import org.openqa.selenium.WebElement;

public class SearchField extends AbstractElement implements IInputField {
    public SearchField(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void clear(){
        wrappedElement.clear();
    }

    @Override
    public void type(final String text) {
        clear();
        wrappedElement.sendKeys(text);
    }
}
