package TrelloTests;

import Helpers.BoardsPageHelper;
import Helpers.HomePageHelper;
import Helpers.LoginPageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TasteBase {
    WebDriver driver;
    HomePageHelper homePage;
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;

    public static final String EMAIL = "hadashqa@gmail.com";
    public static final String PASSWORD = "starQA21";

    @BeforeMethod
    public void startApp() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--lang=" + "en");
//        driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        loginPage = new LoginPageHelper(driver);
        boardsPage = new BoardsPageHelper(driver);
        homePage = new HomePageHelper(driver);
//        driver.manage().window().maximize();
        driver.get("https://trello.com/");
        homePage.waitUntilPageIsLoaded();

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
