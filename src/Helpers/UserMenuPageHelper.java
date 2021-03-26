package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserMenuPageHelper extends PageBase {
    @FindBy(xpath = "//button[@aria-label='Close popover']")
    WebElement memberMenue;
    @FindBy(xpath = "//span[@class='_2TvKKP0vwCN5Zd']")
    WebElement emailText;
    @FindBy(css = "[aria-label='Open member menu']")
    WebElement memButton;

    public UserMenuPageHelper(WebDriver driver) {
        super(driver);
    }

    public String getEmail() {
        return emailText.getText();
    }

    public void enterToMemberMenu() {
        memButton.click();
        waitUntilElementIsVisable(memberMenue, 2);
    }
}
