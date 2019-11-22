package Task4.PageFactory.Containers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class SearchResult extends AContainer {
    @FindAll({
            @FindBy(how = How.XPATH,
                    using = "//h2[@class='search-result-title']")
    })
    private List<WebElement> textFields;

    public List<String> getFields(){
        List<String> rows = new ArrayList<>();

        for (WebElement e:
                textFields) {
            rows.add(e.getAttribute("innerText"));
        }

        return rows;
    }
}
