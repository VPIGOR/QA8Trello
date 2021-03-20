package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserMenuPageHelper extends PageBase {

    public UserMenuPageHelper(WebDriver driver) {
        super(driver);
    }

    public String getEmail() {

        WebElement email = driver.findElement(By.xpath("//span[@class='_2TvKKP0vwCN5Zd']"));
        return email.getText();
    }

    public void enterToMemberMenu() {
        WebElement memberButton = driver.findElement(By.cssSelector("[aria-label='Open member menu']"));
        memberButton.click();
        waitUntilElementIsVisable(By.xpath("//button[@aria-label='Close popover']"), 2);
    }
}
