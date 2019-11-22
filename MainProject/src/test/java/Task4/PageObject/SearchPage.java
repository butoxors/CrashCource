package Task4.PageObject;

import Task4.PageFactory.Containers.SearchForm;
import Task4.PageFactory.Containers.SearchResult;
import Task4.PageFactory.ExtendedFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage extends APage implements ISearchPage {
    @FindBy(xpath = "//div[@class='search-wrapper']")
    private SearchForm searchForm;

    @FindBy(xpath = "//ul[@class='search-results row']")
    private SearchResult searchResult;

    public void search(final String query){
        //wait(searchForm.getElement());
        waitOverlay();
        searchForm.search(query);
    }

    public List<String> getSearchResult(){
        //wait(searchResult.getElement());
        waitOverlay();
        return searchResult.getFields();
    }

    @Override
    public void init(final WebDriver webDriver) {
        wait = new WebDriverWait(webDriver, 3);
        PageFactory.initElements(new ExtendedFieldDecorator(webDriver), this);
    }

}
