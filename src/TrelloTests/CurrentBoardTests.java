package TrelloTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    public  void addList(String name) throws InterruptedException {
        WebElement addList = driver.findElement(By.cssSelector("[class='placeholder']"));
        addList.click();
        Thread.sleep(2000);
        WebElement listName = driver.findElement(By.className("list-name-input"));
        fillField(listName, name);
        WebElement clickAddButton = driver.findElement(By.cssSelector("[type='submit']"));
        clickAddButton.click();
        Thread.sleep(2000);
        WebElement x = driver.findElement(By.cssSelector(".js-cancel-edit"));
        x.click();
    }

    @Test
    public void createNewList() throws InterruptedException {
        addList("My first list");
    }


    @Test
    public void changeListName() throws InterruptedException {
        int countLists = driver.findElements(By.xpath("//textarea[./@dir='auto']")).size();
        if (countLists == 0) {
           addList("empty list");
            countLists++;
        }

        WebElement lastList = driver.findElements(By.xpath("//textarea[./@dir='auto']")).get(countLists - 1);
        String newName = "new changed name";
        fillField(lastList, newName);
        lastList.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WebElement forTest = driver.findElements(By.xpath("//div[@class='list-header js-list-header u-clearfix is-menu-shown']")).get(countLists - 1);
        Assert.assertEquals(forTest.getText(), newName, "THE LIST NAME DIDN'T CHANGE");
    }

    @Test
    public void addCard() throws InterruptedException {
        int countLists = driver.findElements(By.xpath("//span[@class='js-add-a-card']")).size();
        if (countLists == 0) {
            addList("empty list");
            countLists++;
        }
        WebElement createCard = driver.findElements(By.xpath("//span[@class='js-add-a-card']")).get(countLists-1);
        createCard.click();
        WebElement enterName = driver.findElement(By.cssSelector(".js-card-title"));
        fillField(enterName,"Good Card");
        WebElement addCard = driver.findElement(By.cssSelector(".js-add-card"));
        addCard.click();
        WebElement xButton = driver.findElement(By.cssSelector(".js-cancel"));
        xButton.click();
        WebElement toCheck = driver.findElements(By.cssSelector(".list-cards")).get(countLists-1);
        Assert.assertTrue(toCheck.isEnabled());
    }
}
