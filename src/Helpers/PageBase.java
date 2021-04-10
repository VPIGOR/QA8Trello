package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageBase {
    WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilElementIsClickabl(WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void waitUntilElementIsVisable(WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String getPagTitle(){
        return driver.getTitle();
    }
    public void waitUntilTitleIs(String str, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.titleIs(str));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void fillField(WebElement element, String value) {
        element.clear();
        element.click();
        element.sendKeys(value);
    }
    public void waiterWithThread(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    //-------------open new tab-------------------------
    // JavascriptExecutor js = (JavascriptExecutor)driver;
    // js.executeScript("window.open()");

    //--------------get name all of tabs-------------------
    //ArrayList<String> list = new ArrayList<>(driver.getWindowHandles());

    //---------------go to tab---------------------------------
    // driver.switchTo().window(list.get(1));
}