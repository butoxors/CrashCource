package Task4.PageFactory.Containers;

import Task4.PageFactory.Elements.SearchButton;
import Task4.PageFactory.Elements.SearchField;
import org.openqa.selenium.support.FindBy;

public class SearchForm extends AContainer {
    @FindBy(xpath = "//input[@type='text' and @maxlength=1000]")
    private SearchField searchField;

    @FindBy(xpath = "//input[@type='submit' and @value=' Пошук']")
    private SearchButton searchButton;

    public void search(final String text){
        searchField.type(text);
        searchButton.click();
    }
}
