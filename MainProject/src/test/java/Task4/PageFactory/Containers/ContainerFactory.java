package Task4.PageFactory.Containers;

import org.openqa.selenium.WebElement;

public interface ContainerFactory {
    <C extends AContainer> C create(Class<C> containerClass, WebElement wrappedElement);
}
