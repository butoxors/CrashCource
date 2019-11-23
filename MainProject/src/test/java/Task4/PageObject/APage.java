package Task4.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class APage implements IPage{
    protected WebDriverWait wait;

    public void wait(WebElement element){
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
        }catch (Exception e){}
    }
    public void waitOverlay(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader")));
    }
}
