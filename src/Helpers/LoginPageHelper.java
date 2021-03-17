package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageHelper extends PageBase {

    public LoginPageHelper(WebDriver driver) {

        super(driver);
    }

    public void waitUntilPageIsLoaded() {

        waitUntilElementIsClickabl(By.id("user"), 10);
    }

    public void openLoginPage() {
        driver.findElement(By.xpath("//*[@class='btn btn-sm btn-link text-primary']")).click();
    }

    public void enterLoginNotAttl(String mail) {
        WebElement email = driver.findElement(By.id("user"));
        fillField(email, mail);
    }

    public void enterPasswordNoAtl(String pas) {
        WebElement pass = driver.findElement(By.id("password"));
        fillField(pass, pas);
    }


    public void weitThread(int time) {
        waiterWithThread(time);
    }

    public void clicToLoginField() {
        driver.findElement(By.id("login")).click();
    }

    public void waitUntilErrorMessageIsPresent() {
        waitUntilElementIsVisable(By.id("error"), 5);
    }

    public void waitUntilPassFildPresent() {
        waitUntilElementIsClickabl(By.cssSelector(".field-group"), 5);
    }

    public void clickToPasswoIn() {
        driver.findElement(By.id("login-submit")).click();
    }

    public void waitUntilLoginErrorMessageIsPresent() {
        waitUntilElementIsVisable(By.id("login-error"), 10);
    }
}
