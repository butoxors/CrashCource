package DataProviderTask.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchPage extends BasePage{
    @FindAll({
        @FindBy(className = "LC20lb")
    })
    private List<WebElement> _resultColumn;

    public int checkCountQueries(String query){
        List<String> res = new ArrayList<>();

        for (WebElement s:
             _resultColumn) {
            String actual = s.getAttribute("innerText");

            if (actual.toLowerCase().contains(query.toLowerCase()))
                res.add(actual);
        }
        return res.size();
    }

}
