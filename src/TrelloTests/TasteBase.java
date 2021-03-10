package TrelloTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TasteBase {
    WebDriver driver;

    @BeforeMethod
    public void startApp() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=" + "en");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://trello.com/");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void finishApp() {
        driver.quit();
    }

    public void fillField(WebElement element, String value) throws InterruptedException {
        element.clear();
        element.click();
        element.sendKeys(value);
        Thread.sleep(2000);
    }
}
