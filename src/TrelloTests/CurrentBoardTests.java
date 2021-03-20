package TrelloTests;

import Helpers.CurrentBoardPageHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CurrentBoardTests extends TasteBase {
    CurrentBoardPageHelper currentBoard;

    @BeforeMethod
    public void init() {
        currentBoard = new CurrentBoardPageHelper(driver);
        loginPage.openLoginPage();
        loginPage.loginExistEmailAnyPass("hadashqa@gmail.com", "starQA21");
        boardsPage.waitUntilPageIsLoaded();
        currentBoard.enterToQaHaifa8Board();
    }


    @Test
    public void createNewList() {
        currentBoard.addEmptyList("emty list");
        Assert.assertEquals(currentBoard.testLists, 1, "List didn't add");
    }


    @Test
    public void changeLastListName() {
        currentBoard.ifBoardEmpty();
        currentBoard.changeListName("new changed name", currentBoard.listsSize() - 1);
        Assert.assertEquals(currentBoard.getListName(currentBoard.listsSize() - 1), "new changed name", "THE LIST NAME DIDN'T CHANGE");
    }

    @Test
    public void addCard() {
        currentBoard.ifBoardEmpty();
        currentBoard.addCard("Good Card", currentBoard.listsSize() - 1);
        Assert.assertEquals(currentBoard.testCards, 1, "Card wasn't added");
    }

    @Test
    public void deletionList() {
        currentBoard.ifBoardEmpty();
        currentBoard.dellList(0);
        Assert.assertEquals(currentBoard.testLists, 1, "List didn't delete");
    }
}
