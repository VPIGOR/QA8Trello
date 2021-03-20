package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CurrentBoardPageHelper extends PageBase {

    public int testLists;
    public int testCards;


    public CurrentBoardPageHelper(WebDriver driver) {
        super(driver);
    }

    public void enterToQaHaifa8Board() {
        WebElement qaHaifa8Board = driver.findElement(By.xpath("//a[@class = 'board-tile'][.//@title='QA Haifa8']"));
        qaHaifa8Board.click();
        waitUntilTitleIs("QA Haifa8 | Trello", 10);
    }


    public void addEmptyList(String name) {
        int countListsBefore = listsSize();
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
        int countListsAfter = listsSize();
        testLists = countListsAfter - countListsBefore;

    }

    public int listsSize() {
        return driver.findElements(By.xpath("//div[@class='js-list list-wrapper']")).size();
    }

    public int cardSize() {
        return driver.findElements(By.xpath("//a[@class='list-card js-member-droppable ui-droppable']")).size();
    }

    public void ifBoardEmpty() {
        int countLists = listsSize();
        if (countLists == 0) {
            addEmptyList("first list");
        }
    }

    public void changeListName(String listName, int listNum) {
        WebElement lastList = driver.findElements(By.cssSelector(".list-header-name")).get(listNum);
        lastList.clear();
        lastList.sendKeys(listName);
        lastList.sendKeys(Keys.ENTER);
        driver.navigate().refresh();
    }

    public String getListName(int listNum) {
        WebElement listName = driver.findElements(By.xpath("//div[@class='list-header js-list-header u-clearfix is-menu-shown']")).get(listNum);
        return listName.getText();
    }

    public void addCard(String cardName, int listNum) {
        int countOfCardBefore = cardSize();
        WebElement createCard = driver.findElements(By.xpath("//a[@class='open-card-composer js-open-card-composer']")).get(listNum);
        createCard.click();
        WebElement enterName = driver.findElement(By.cssSelector(".js-card-title"));
        fillField(enterName, cardName);
        WebElement addCard = driver.findElement(By.cssSelector(".js-add-card"));
        addCard.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement xButton = driver.findElement(By.cssSelector(".js-cancel"));
        xButton.click();
        driver.navigate().refresh();
        int countOfCardsAfter = cardSize();
        testCards = countOfCardsAfter - countOfCardBefore;
    }

    public void dellList(int listNum) {
        int countListsBefore = listsSize();
        WebElement menuIcon = driver.findElements(By.cssSelector(".list-header-extras-menu")).get(listNum);
        menuIcon.click();
        waitUntilElementIsVisable(By.cssSelector(".js-close-list"), 5);
        WebElement delete = driver.findElement(By.className("js-close-list"));
        delete.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        int countListsAfter = listsSize();
        testLists = countListsBefore-countListsAfter;
    }
}
