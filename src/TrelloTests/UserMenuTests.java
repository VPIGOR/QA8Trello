package TrelloTests;



import Helpers.UserMenuPageHelper;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserMenuTests extends TasteBase {
    UserMenuPageHelper userHelper;
     @BeforeMethod
    public void init(){
         userHelper = PageFactory.initElements(driver,UserMenuPageHelper.class);
         loginPage.openLoginPage();
         loginPage.loginExistEmailAnyPass(EMAIL, PASSWORD);
         boardsPage.waitUntilPageIsLoaded();
         userHelper.enterToMemberMenu();
     }
     @Test
    public void emailCheckTest(){
         Assert.assertEquals(userHelper.getEmail(),EMAIL,"it's not my mail");
     }
}
