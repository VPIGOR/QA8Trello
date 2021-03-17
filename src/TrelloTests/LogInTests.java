package TrelloTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends TasteBase {

    @BeforeMethod
    public  void  init() {
        loginPage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();

    }
    @Test
    public void loginNegativeTestAllWrongData() {
        loginPage.enterLoginNotAttl("email@jac.com");
        loginPage.enterPasswordNoAtl("password");
        loginPage.weitThread(1000);
        loginPage.clicToLoginField();
        loginPage.waitUntilErrorMessageIsPresent();
        Assert.assertTrue(loginPage.isDisplayErrorMessage(),"the message doesn't displayd");
    }

    @Test
    public void loginNegativeTestWrongPassword() {
        loginPage.enterLoginNotAttl("hadashqa@gmail.com");
        loginPage.clicToLoginField();
        loginPage.waitUntilPassFildPresent();
        loginPage.enterPasswordNoAtl("password");
        loginPage.clickToPasswoIn();
        loginPage.waitUntilLoginErrorMessageIsPresent();
        Assert.assertTrue(loginPage.isDisplayLoginErrorMessage(),"the message doesn't displayd");
    }

    @Test
    public void loginPossetiveTest() {
        WebElement email = driver.findElement(By.id("user"));
        fillField(email, "hadashqa@gmail.com");
        waitUntilElementIsClickabl(By.xpath("//input[@value='Log in with Atlassian']"),5);
        WebElement logIn = driver.findElement(By.id("login"));
        logIn.click();
        waitUntilElementIsClickabl(By.id("login-submit"),5);
        WebElement pass = driver.findElement(By.id("password"));
        fillField(pass, "starQA21");
        WebElement submit = driver.findElement(By.id("login-submit"));
        submit.click();
        waitUntilTitleIs("Boards | Trello",10);
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Boards | Trello","something vrong");
    }


}
