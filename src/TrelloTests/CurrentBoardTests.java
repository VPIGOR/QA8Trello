package TrelloTests;

import Helpers.CurrentBoardPageHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CurrentBoardTests extends TasteBase {
    CurrentBoardPageHelper currentBoard;

    @BeforeMethod
    public void init() {
        currentBoard = new CurrentBoardPageHelper(driver,"QA Haifa8");
        loginPage.openLoginPage();
        loginPage.loginExistEmailAnyPass(EMAIL, PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        boardsPage.enterToCurrentBoard(currentBoard.boardName);
    }


    @Test
    public void createNewList() {
        int countOfListsBefore = currentBoard.listsSize();
        currentBoard.addEmptyList("emty list");
        int countOfListsAfter = currentBoard.listsSize();
        Assert.assertEquals(countOfListsBefore+1,countOfListsAfter, "List didn't add");
    }


    @Test
    public void changeLastListName() {
        currentBoard.ifBoardsListEmpty();
        currentBoard.changeListName("new changed name", currentBoard.listsSize() - 1);
        Assert.assertEquals(currentBoard.getListName(currentBoard.listsSize() - 1), "new changed name", "THE LIST NAME DIDN'T CHANGE");
    }

    @Test
    public void addCard() {
        currentBoard.ifBoardsListEmpty();
        currentBoard.addCard("Good Card", currentBoard.listsSize() - 1);
        Assert.assertEquals(currentBoard.testCards, 1, "Card wasn't added");
    }

    @Test
    public void deletionList() {
        currentBoard.ifBoardsListEmpty();
        currentBoard.dellList(0);
        Assert.assertEquals(currentBoard.testLists, 1, "List didn't delete");
    }
}
