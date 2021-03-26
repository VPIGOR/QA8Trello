package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHelper extends PageBase {
    @FindBy(css = ".field-group")
    WebElement passField;
    @FindBy(id = "user")
    WebElement emailField;
    @FindBy(xpath = "//*[@class='btn btn-sm btn-link text-primary']")
    WebElement enterTologinPageButton;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "login")
    WebElement loginButton;
    @FindBy(id = "login-submit")
    WebElement loginSubmitButton;
    @FindBy(id = "error")
    WebElement errorMassage;
    @FindBy(id = "login-error")
    WebElement loginErrorMasage;

    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }



    public void enterLoginAndPassNoAtl(String log, String pas) {
        this.enterLoginNotAttl(log);
        this.enterPasswordNoAtl(pas);
        this.clicToLoginField();
        waitUntilElementIsVisable(errorMassage, 5);
    }

    public void loginExistEmailAnyPass(String mail, String pas) {
        this.enterLoginNotAttl(mail);
        this.clicToLoginField();
        this.waitUntilPassFildPresent();
        this.enterPasswordNoAtl(pas);
        this.clickToPasswoIn();

    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickabl(emailField, 10);
    }

    public void openLoginPage() {
        enterTologinPageButton.click();
    }

    public void enterLoginNotAttl(String mail) {
        fillField(emailField, mail);
    }

    public void enterPasswordNoAtl(String pas) {
        fillField(passwordField, pas);
        waiterWithThread(1000);
    }

    public void clicToLoginField() {
        loginButton.click();
    }

    public void waitUntilPassFildPresent() {
        waitUntilElementIsClickabl(passField, 5);
    }

    public void clickToPasswoIn() {
        loginSubmitButton.click();
    }

    public boolean isDisplayErrorMessage() {
        return errorMassage.isDisplayed();
    }

    public void waitUntilLoginErrorMessageIsPresent() {
        waitUntilElementIsVisable(loginErrorMasage, 10);
    }

    public boolean isDisplayLoginErrorMessage() {
        return loginErrorMasage.isDisplayed();
    }


}
