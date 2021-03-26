package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CurrentBoardPageHelper extends PageBase {
    @FindBy(css = "[class='placeholder']")
    WebElement placHolder;
    @FindBy(className = "list-name-input")
    WebElement listNameField;
    @FindBy(css = ".js-close-list")
    WebElement arhiveButton;
    @FindBy(css = ".js-cancel-edit")
    WebElement cancelEditButton;
    @FindBy(css = "[type='submit']")
    WebElement submitNameButton;

    public int testLists;
    public int testCards;
    public String boardName;

    public CurrentBoardPageHelper(WebDriver driver,String boardName) {
        super(driver);
        this.boardName =boardName;
        PageFactory.initElements(driver,this);

    }


    public void addEmptyList(String name) {
        int countListsBefore = listsSize();
        ClickAddListButton();
        enterListName(name);
        clickSubmitChangeNameButton();
        clickCancelEditButton();
        int countListsAfter = listsSize();
        testLists = countListsAfter - countListsBefore;

    }

    public void addCard(String cardName, int listNum) {
        int countOfCardBefore = cardSize();
        clickCreateCardButton(listNum);
        enterNameOfCard(cardName);
        clickAddCreatedCardButton();
        closeAddCardIcon();
        int countOfCardsAfter = cardSize();
        testCards = countOfCardsAfter - countOfCardBefore;
    }

    public void dellList(int listNum) {
        int countListsBefore = listsSize();
        clickMenuOflistButton(listNum);
        archiveThisList();
        int countListsAfter = listsSize();
        testLists = countListsBefore - countListsAfter;
    }

    private void clickCancelEditButton() {
        cancelEditButton.click();
        waitUntilElementIsVisable(placHolder, 5);
    }

    public void clickSubmitChangeNameButton() {
        submitNameButton.click();
    }

    public void enterListName(String name) {
        WebElement listName = driver.findElement(By.className("list-name-input"));
        fillField(listName, name);
    }

    public void ClickAddListButton() {
        WebElement addList = driver.findElement(By.cssSelector("[class='placeholder']"));
        addList.click();
        waitUntilElementIsVisable(listNameField, 5);
    }

    public int listsSize() {
        return driver.findElements(By.xpath("//div[@class='js-list list-wrapper']")).size();
    }

    public int cardSize() {
        return driver.findElements(By.xpath("//a[@class='list-card js-member-droppable ui-droppable']")).size();
    }

    public void ifBoardsListEmpty() {
        if (listsSize() == 0) {
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


    private void closeAddCardIcon() {
        WebElement xButton = driver.findElement(By.cssSelector(".js-cancel"));
        xButton.click();
        driver.navigate().refresh();
    }

    private void clickAddCreatedCardButton() {
        WebElement addCard = driver.findElement(By.cssSelector(".js-add-card"));
        addCard.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    private void enterNameOfCard(String cardName) {
        WebElement enterName = driver.findElement(By.cssSelector(".js-card-title"));
        fillField(enterName, cardName);
    }

    private void clickCreateCardButton(int listNum) {
        WebElement createCard = driver.findElements(By.xpath("//a[@class='open-card-composer js-open-card-composer']")).get(listNum);
        createCard.click();
    }

    private void archiveThisList() {
        arhiveButton.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    private void clickMenuOflistButton(int listNum) {
        WebElement menuIcon = driver.findElements(By.cssSelector(".list-header-extras-menu")).get(listNum);
        menuIcon.click();
        waitUntilElementIsVisable(arhiveButton, 5);
    }
}
