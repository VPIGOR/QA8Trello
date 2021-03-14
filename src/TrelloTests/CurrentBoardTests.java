package TrelloTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CurrentBoardTests extends TasteBase {

    @BeforeMethod
    public void init() {
        driver.findElement(By.xpath("//*[@class='btn btn-sm btn-link text-primary']")).click();
        waitUntilElementIsClickabl(By.id("user"), 10);
        WebElement email = driver.findElement(By.id("user"));
        fillField(email, "hadashqa@gmail.com");
        waitUntilElementIsClickabl(By.xpath("//input[@value='Log in with Atlassian']"), 5);
        WebElement logIn = driver.findElement(By.id("login"));
        logIn.click();
        waitUntilElementIsClickabl(By.id("login-submit"), 5);
        WebElement pass = driver.findElement(By.id("password"));
        fillField(pass, "starQA21");
        WebElement submit = driver.findElement(By.id("login-submit"));
        submit.click();
        waitUntilTitleIs("Boards | Trello", 10);
        WebElement qaHaifa8Board = driver.findElement(By.xpath("//a[@class = 'board-tile'][.//@title='QA Haifa8']"));
        qaHaifa8Board.click();
        waitUntilTitleIs("QA Haifa8 | Trello", 10);
    }

    public void addList(String name) {
        int countListsBefore = driver.findElements(By.xpath("//span[@class='js-add-a-card']")).size();
        WebElement addList = driver.findElement(By.cssSelector("[class='placeholder']"));
        addList.click();
        waitUntilElementIsVisable(By.className("list-name-input"), 5);
        WebElement listName = driver.findElement(By.className("list-name-input"));
        fillField(listName, name);
        WebElement clickAddButton = driver.findElement(By.cssSelector("[type='submit']"));
        clickAddButton.click();
        WebElement x = driver.findElement(By.cssSelector(".js-cancel-edit"));
        x.click();
        waitUntilElementIsVisable(By.cssSelector("[class='placeholder']"), 5);
        int countListsAfter = driver.findElements(By.xpath("//span[@class='js-add-a-card']")).size();
        Assert.assertEquals(countListsBefore + 1, countListsAfter, "List didn't add");

    }

    @Test
    public void createNewList() {
        int countListsBefore = driver.findElements(By.xpath("//span[@class='js-add-a-card']")).size();
        addList("My first list");
        int countListsAfter = driver.findElements(By.xpath("//span[@class='js-add-a-card']")).size();
        Assert.assertEquals(countListsBefore + 1, countListsAfter, "List didn't add");
    }


    @Test
    public void changeListName() {
        int countLists = driver.findElements(By.xpath("//textarea[./@dir='auto']")).size();
        if (countLists == 0) {
            addList("empty list");
            countLists++;
        }
        WebElement lastList = driver.findElements(By.cssSelector(".list-header-name")).get(countLists - 1);
        String newName = "new changed name";
        lastList.clear();
        lastList.sendKeys(newName);
        lastList.sendKeys(Keys.ENTER);
        driver.navigate().refresh();
        WebElement forTest = driver.findElements(By.xpath("//div[@class='list-header js-list-header u-clearfix is-menu-shown']")).get(countLists - 1);
        Assert.assertEquals(forTest.getText(), newName, "THE LIST NAME DIDN'T CHANGE");
    }

    @Test
    public void addCard() {
        int countLists = driver.findElements(By.xpath("//div[@class='js-list list-wrapper']")).size();
        if (countLists == 0) {
            addList("empty list");
            countLists++;
        }
        int countOfCardBefore = driver.findElements(By.xpath("//a[@class='list-card js-member-droppable ui-droppable']")).size();
        WebElement createCard = driver.findElements(By.xpath("//a[@class='open-card-composer js-open-card-composer']")).get(countLists - 1);
        createCard.click();
        WebElement enterName = driver.findElement(By.cssSelector(".js-card-title"));
        fillField(enterName, "Good Card");
        WebElement addCard = driver.findElement(By.cssSelector(".js-add-card"));
        addCard.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement xButton = driver.findElement(By.cssSelector(".js-cancel"));
        xButton.click();
        driver.navigate().refresh();
        int countOfCardsAfter = driver.findElements(By.xpath("//a[@class='list-card js-member-droppable ui-droppable']")).size();
        Assert.assertEquals(countOfCardBefore + 1, countOfCardsAfter, "Card wasn't added");
    }

    @Test
    public void deletionList() {
        int countListsBefore = driver.findElements(By.xpath("//span[@class='js-add-a-card']")).size();
        if (countListsBefore == 0) {
            addList("empty list");
            countListsBefore++;
        }
        WebElement menuIcon = driver.findElements(By.cssSelector(".list-header-extras-menu")).get(0);
        menuIcon.click();
        waitUntilElementIsVisable(By.cssSelector(".js-close-list"), 5);
        WebElement delete = driver.findElement(By.className("js-close-list"));
        delete.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        int countListsAfter = driver.findElements(By.xpath("//span[@class='js-add-a-card']")).size();
        Assert.assertEquals(countListsBefore - 1, countListsAfter, "List didn't delete");
    }
}
