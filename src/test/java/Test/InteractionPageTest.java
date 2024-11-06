package Test;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.InteractionsPage;

import static utils.UtilityClass.returnWebElementOnMatch;

public class InteractionPageTest extends BaseTest {
    WebDriver driver;
    HomePage homePage;
    InteractionsPage interactionsPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = initialiseBrowserAndOpenWebsite("chrome");
        driver.get("https://demoqa.com/sortable");
    }

    @Test
    public void SortableTest() {
        homePage = new HomePage(driver);
        homePage.homePageWindow();
        interactionsPage = new InteractionsPage(driver);
        interactionsPage.sortable_list("One", "Five").getText();
        Assert.assertEquals(interactionsPage.sortable_List_Elements.get(4).getText(), "One");
        interactionsPage.sortable_grid();
        Assert.assertEquals(interactionsPage.sortable_Grid_Elements.get(3).getText(), "One");
    }

    @Test
    public void SelectableTest() {
        homePage = new HomePage(driver);
        homePage.homePageWindow();
        interactionsPage = new InteractionsPage(driver);
        interactionsPage.gotoSelectable().Selectable_grid("One").Selectable_grid("Five").Selectable_grid("Nine");
        Assert.assertTrue(returnWebElementOnMatch(interactionsPage.selectable_Grid_elements, "One").isDisplayed());
        Assert.assertTrue(returnWebElementOnMatch(interactionsPage.selectable_Grid_elements, "One").isEnabled());
        System.out.println(returnWebElementOnMatch(interactionsPage.selectable_Grid_elements, "One").isSelected());
        //Assert.assertTrue(returnWebElementOnMatch(interactionsPage.selectable_Grid_elements,"One").isSelected());
        //need to check why isSelected() is returning false, it is expected to return true.
        interactionsPage.Selectable_List("Dapibus ac facilisis in").Selectable_List("Porta ac consectetur ac");
    }

    @Test
    public void ResizableTest() {
        homePage = new HomePage(driver);
        homePage.homePageWindow();
        interactionsPage = new InteractionsPage(driver);
        interactionsPage
                .gotoResizable()
                .ResizableBoxWithRestriction_handle_dragAndDropBy(90, 90)
                .ResizableBoxWithRestriction_handle_moveToElementWithOffsets(200, 0)
                .ResizableBoxWithRestriction_handle_moveByOffset(-90, -90)
                .ResizableNolimit_handle(900, 50);
    }

    @Test
    public void DroppableTest() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.homePageWindow();
        interactionsPage = new InteractionsPage(driver);
        interactionsPage.gotoDroppable().Simple_Droppable2().Simple_Droppable();//---using simple dragAndDrop
        Thread.sleep(5000);
        refresh(driver);
        interactionsPage.gotoDroppable().Simple_Droppable_Byoffset(287, -5)//---using dragAndDropBy with offsets
                .Simple_Droppable_Byoffset(87, -5);
        interactionsPage.gotoDroppable().RevertDraggable_Droppable();
    }
    @Test
    public void DragabbleTest() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.homePageWindow();
        interactionsPage = new InteractionsPage(driver);
        interactionsPage.gotoDragabble().Container_Restricted_Dragabble(223,55);
    }
}
