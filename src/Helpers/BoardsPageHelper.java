package Helpers;

import org.openqa.selenium.WebDriver;

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
}
