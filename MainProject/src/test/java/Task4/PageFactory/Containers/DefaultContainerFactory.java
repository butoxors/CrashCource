package Task4.PageFactory.Containers;

import org.openqa.selenium.WebElement;

public class DefaultContainerFactory implements  ContainerFactory{
    @Override
    public <C extends AContainer> C create(final Class<C> containerClass, final WebElement wrappedElement) {
        final C container = createInstanceOf(containerClass);
        container.init(wrappedElement);
        return container;
    }

    private <C extends AContainer> C createInstanceOf(final Class<C> containerClass) {
        try {
            return containerClass.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
