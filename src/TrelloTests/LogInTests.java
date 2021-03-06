package TrelloTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests {
    WebDriver driver;

    @BeforeMethod
    public void enter() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://trello.com/");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void exit() {
        driver.quit();
    }

    @Test
    public void loginNegativeTest() throws InterruptedException {

        driver.findElement(By.xpath("//*[@class='btn btn-sm btn-link text-primary']")).click();
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.id("user"));
        fillField(email, "mail@my.foo");
        WebElement pass = driver.findElement(By.id("password"));
        fillField(pass, "password");
        WebElement logIn = driver.findElement(By.id("login"));
        logIn.click();
        Thread.sleep(2000);
        WebElement message = driver.findElement(By.id("error"));
        System.out.println(message.getText());
    }
    @Test
    public void loginPossetiveTest() throws InterruptedException {

        driver.findElement(By.xpath("//*[@class='btn btn-sm btn-link text-primary']")).click();
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.id("user"));
        fillField(email, "hadashqa@gmail.com");
        WebElement logIn = driver.findElement(By.id("login"));
        logIn.click();
        Thread.sleep(2000);
        WebElement pass = driver.findElement(By.id("password"));
        fillField(pass, "starQA21");
        WebElement submit = driver.findElement(By.id("login-submit"));
        submit.click();
        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println(title);
        if(title.contains("Trello")){
            System.out.println("PASS");
        }else System.out.println("NOT PASS");
    }

    public void fillField(WebElement element, String value) throws InterruptedException {
        element.clear();
        element.click();
        element.sendKeys(value);
        Thread.sleep(2000);
    }
}
