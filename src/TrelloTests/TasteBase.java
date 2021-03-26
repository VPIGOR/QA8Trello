package TrelloTests;

import Helpers.BoardsPageHelper;
import Helpers.HomePageHelper;
import Helpers.LoginPageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
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
        loginPage = PageFactory.initElements(driver,LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver,BoardsPageHelper.class);
        homePage = PageFactory.initElements(driver,HomePageHelper.class);
//        driver.manage().window().maximize();
        driver.get("https://trello.com/");
        homePage.waitUntilPageIsLoaded();

    }

    @AfterMethod
    public void finishApp() {
        driver.quit();
    }


}
