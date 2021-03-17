package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageHelper extends PageBase {


    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickabl(By.xpath("//*[@class='btn btn-sm btn-link text-primary']"),40);
    }
    public String getPageTitle(){
       return  driver.getTitle();
    }


}
