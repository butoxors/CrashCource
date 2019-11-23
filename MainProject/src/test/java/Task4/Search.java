package Task4;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class Search extends BaseTest{

    private final String SEARCH_QUERY = "IT Академія";

    @Test(groups = {"searchTest"})
    public void goToSearchPage() {
        driver.navigate().refresh();
        mainPage.goToSearch();
    }

    @Test(groups = {"searchTest"}, dependsOnMethods = "goToSearchPage", priority = 1)
    public void writeQuery(){
        searchPage.search(SEARCH_QUERY);
    }

    @Test(priority = 2,
            groups = {"searchTest"},
            dependsOnMethods = "writeQuery")
    public void checkRowCount() {
        List<String> list = searchPage.getSearchResult();
        boolean numberRows = list.size() > 0;
        System.out.println("Count of results: " + list.size());
        Assert.assertEquals(true, numberRows);
    }

    private boolean checkQuery(List<String> vals){
        for(String val : vals){
            if (val.toLowerCase().contains(SEARCH_QUERY.toLowerCase()))
                return true;
        }
        return false;
    }

    @Test(priority = 2,
            dependsOnMethods = "writeQuery",
            groups = {"searchTest"})
    public void checkRowData() {
        List<String> rows = searchPage.getSearchResult();
        System.out.println("Searching results:");
        for (String r:
             rows) {
            System.out.println(r);
        }
        Assert.assertEquals(true, checkQuery(rows));
    }

}
