package Task4.PageFactory;

import Task4.PageFactory.Elements.IElement;
import org.openqa.selenium.WebElement;

public interface ElementFactory {
    <E extends IElement> E create(Class<E> elementClass, WebElement wrappedElement);
}
