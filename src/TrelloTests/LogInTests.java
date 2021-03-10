package TrelloTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends TasteBase {

    @BeforeMethod
    public  void  init() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='btn btn-sm btn-link text-primary']")).click();
        Thread.sleep(3000);
    }
    @Test
    public void loginNegativeTestAllWrongData() throws InterruptedException {
        WebElement email = driver.findElement(By.id("user"));
        fillField(email, "mail@my.foo");
        WebElement pass = driver.findElement(By.id("password"));
        fillField(pass, "password");
        WebElement logIn = driver.findElement(By.id("login"));
        logIn.click();
        Thread.sleep(2000);
        WebElement message = driver.findElement(By.id("error"));
        System.out.println(message.getText());
        Assert.assertTrue(message.isDisplayed(),"the message doesn't displayd");
    }

    @Test
    public void loginNegativeTestWrongPassword() throws InterruptedException {
        WebElement email = driver.findElement(By.id("user"));
        fillField(email, "hadashqa@gmail.com");
        WebElement logIn = driver.findElement(By.id("login"));
        logIn.click();
        Thread.sleep(2000);
        WebElement pass = driver.findElement(By.id("password"));
        fillField(pass, "password");
        WebElement submit = driver.findElement(By.id("login-submit"));
        submit.click();
        Thread.sleep(2000);
        WebElement massage = driver.findElement(By.id("login-error"));
        Assert.assertTrue(massage.isDisplayed(),"the message doesn't displayd");
    }

    @Test
    public void loginPossetiveTest() throws InterruptedException {
        WebElement email = driver.findElement(By.id("user"));
        fillField(email, "hadashqa@gmail.com");
        WebElement logIn = driver.findElement(By.id("login"));
        logIn.click();
        Thread.sleep(2000);
        WebElement pass = driver.findElement(By.id("password"));
        fillField(pass, "starQA21");
        WebElement submit = driver.findElement(By.id("login-submit"));
        submit.click();
        Thread.sleep(5000);
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Boards | Trello","something vrong");
    }


}
