package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageHelper extends PageBase {
     @FindBy(xpath = "//*[@class='btn btn-sm btn-link text-primary']")
     WebElement loginIcon;


    public HomePageHelper(WebDriver driver) {
        super(driver);
    }



    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickabl(loginIcon,40);
    }
    public String getPageTitle(){
       return  driver.getTitle();
    }


}
