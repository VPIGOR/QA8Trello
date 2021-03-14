package TrelloTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends TasteBase {

    @BeforeMethod
    public  void  init() {
        driver.findElement(By.xpath("//*[@class='btn btn-sm btn-link text-primary']")).click();
        waitUntilElementIsClickabl(By.id("user"),10);
    }
    @Test
    public void loginNegativeTestAllWrongData() {
        WebElement email = driver.findElement(By.id("user"));
        fillField(email, "mail@my.foo");
        WebElement pass = driver.findElement(By.id("password"));
        fillField(pass, "password");
        WebElement logIn = driver.findElement(By.id("login"));
        logIn.click();
        waitUntilElementIsClickabl(By.id("error"),5);
        WebElement message = driver.findElement(By.id("error"));
        System.out.println(message.getText());
        Assert.assertTrue(message.isDisplayed(),"the message doesn't displayd");
    }

    @Test
    public void loginNegativeTestWrongPassword() {
        WebElement email = driver.findElement(By.id("user"));
        fillField(email, "hadashqa@gmail.com");
        WebElement logIn = driver.findElement(By.id("login"));
        logIn.click();
        waitUntilElementIsClickabl(By.cssSelector(".field-group"),5);
        WebElement pass = driver.findElement(By.id("password"));
        fillField(pass, "password");
        WebElement submit = driver.findElement(By.id("login-submit"));
        submit.click();
        waitUntilElementIsVisable(By.id("login-error"),10);
        WebElement massage = driver.findElement(By.id("login-error"));
        Assert.assertTrue(massage.isDisplayed(),"the message doesn't displayd");
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
