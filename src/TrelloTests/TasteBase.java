package TrelloTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TasteBase {
    WebDriver driver;

    @BeforeMethod
    public void startApp() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--lang=" + "en");
//        driver = new ChromeDriver(options);
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("https://trello.com/");
//        Thread.sleep(2000);
        waitUntilElementIsClickabl(By.xpath("//*[@class='btn btn-sm btn-link text-primary']"),40);
    }

    public void waitUntilElementIsClickabl(By locator, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(locator));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void waitUntilElementIsVisable(By locator, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void waitUntilTitleIs(String str, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.titleIs(str));
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @AfterMethod
    public void finishApp() {
        driver.quit();
    }

    public void fillField(WebElement element, String value) {
        element.clear();
        element.click();
        element.sendKeys(value);
    }
}
