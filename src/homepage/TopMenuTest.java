package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void selectMenu(String menu){
        //click on the ‘navigation’ link
        clickOnElement(By.linkText(menu));
    }
    @Test
    public void verifyPageNavigation(){
        //find the element of menu tab
        String menuTab = getTextFromElement(By.linkText("Computers"));
        //calling the selectmenu and clicking on menu to navigate to next pag
        selectMenu(menuTab);

        //verify the navigation page text
        verifyElements("Error message displayed","Computers",By.xpath("//h1[contains(text(),'Computers')]"));
    }
    @After
    public void tearDown(){
      //  closeBrowser();
    }
}
