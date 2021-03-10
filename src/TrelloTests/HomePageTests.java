package TrelloTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends  TasteBase {
    @Test
    public void  appTest(){
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Trello","its app not Trello");
    }
}
