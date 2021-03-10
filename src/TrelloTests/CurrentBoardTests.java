package TrelloTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CurrentBoardTests extends TasteBase {

    @BeforeMethod
    public void init() throws InterruptedException {
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
        Thread.sleep(4000);
        WebElement qaHaifa8Board = driver.findElement(By.xpath("//a[@class = 'board-tile'][.//@title='QA Haifa8']"));
        qaHaifa8Board.click();
        Thread.sleep(2000);
    }

          @Test
           public  void createNewList() throws InterruptedException {
              WebElement addList = driver.findElement(By.cssSelector("[class='placeholder']"));
              addList.click();
              Thread.sleep(2000);
              WebElement listName = driver.findElement(By.className("list-name-input"));
              String nameList = "My first list";
              fillField(listName,nameList);
              WebElement clickAddButton = driver.findElement(By.cssSelector("[type='submit']"));
              clickAddButton.click();
              Thread.sleep(2000);
              WebElement x = driver.findElement(By.cssSelector(".js-cancel-edit"));
              x.click();

          }
}
