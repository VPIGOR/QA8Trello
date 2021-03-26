package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BoardsPageHelper extends PageBase {


    public BoardsPageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded() {
        waitUntilTitleIs("Boards | Trello", 10);
    }

    public String boardsPageTitle() {
        return getPagTitle();
    }

    public void enterToCurrentBoard(String boardName) {
        WebElement qaHaifa8Board = driver.findElement(By.xpath("//a[@class = 'board-tile'][.//@title='"+boardName+"']"));
        qaHaifa8Board.click();
        waitUntilTitleIs(boardName+" | Trello", 10);
    }
}
