package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static utils.UtilityClass.*;

public class InteractionsPage {
    @FindBy(className = "text")
    List<WebElement> subActions;
    @FindBy(css = "div[class=\"vertical-list-container mt-4\"]>div")
    public List<WebElement> sortable_List_Elements;
    @FindBy(css = "div[class=\"create-grid\"]>div")
    public List<WebElement> sortable_Grid_Elements;
    @FindBy(css = "div[class=\"tab-content\"]>div:nth-of-type(2)>div>div>li")
    public List<WebElement> selectable_Grid_elements;
    @FindBy(css = "div[class=\"tab-content\"]>div:nth-of-type(1)>ul>li")
    public List<WebElement> selectable_List_elements;
    @FindBy(id = "demo-tab-grid")
    WebElement Grid_tab;
    @FindBy(id = "demo-tab-list")
    WebElement List_tab;

    @FindBy(css = "div#resizableBoxWithRestriction[class=\"box react-resizable\"]>span")
    WebElement resizableBoxWithRestriction_handle;
    @FindBy(css = "div#resizable>span")
    WebElement resizableNolimit_handle;
    @FindBy(id = "draggable")
    WebElement simple_draggable;
    @FindBy(css = "div[id=\"droppable\"]>p")
    WebElement simple_droppable;
    @FindBy(linkText = "Revert Draggable")
    WebElement RevertDraggable_droppable_tab;
    WebDriver driver;

    public InteractionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public InteractionsPage gotoSortable() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Sortable");
        return new InteractionsPage(driver);
    }

    public InteractionsPage gotoSelectable() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Selectable");
        return new InteractionsPage(driver);
    }

    public InteractionsPage gotoResizable() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Resizable");
        return new InteractionsPage(driver);
    }

    public InteractionsPage gotoDroppable() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Droppable");
        return new InteractionsPage(driver);
    }

    public InteractionsPage gotoDragabble() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Dragabble");
        return new InteractionsPage(driver);
    }

    public InteractionsPage sortable_list(String from, String to) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(returnWebElementOnMatch(sortable_List_Elements, from)).perform();
//        actions.clickAndHold(sortable_List.get(0)).perform();
//        actions.scrollToElement(returnWebElementOnMatch(sortable_List, to)).build().perform();
//        scrollIntoView(driver, returnWebElementOnMatch(sortable_List, to));
        actions.moveToElement(returnWebElementOnMatch(sortable_List_Elements, to)).release().perform();
//        actions.release().build().perform();
        return new InteractionsPage(driver);
    }

    public InteractionsPage sortable_grid() {
        Grid_tab.click();
        Actions actions = new Actions(driver);
        actions.clickAndHold(sortable_Grid_Elements.get(0)).perform();
        actions.moveToElement(sortable_Grid_Elements.get(3)).release().perform();
        return new InteractionsPage(driver);
    }

    public InteractionsPage getText() {
        System.out.println(driver.switchTo().activeElement().getText());
        return new InteractionsPage(driver);
    }

    public InteractionsPage Selectable_grid(String name) {
        Grid_tab.click();
        clickOnMatch(selectable_Grid_elements, name);
        return new InteractionsPage(driver);
    }

    public InteractionsPage Selectable_List(String name) {
        List_tab.click();
        clickOnMatch(selectable_List_elements, name);
        return new InteractionsPage(driver);
    }

    public InteractionsPage ResizableBoxWithRestriction_handle_moveToElementWithOffsets(int width, int height) {
        System.out.println(resizableBoxWithRestriction_handle.getRect().getDimension());
        System.out.println(resizableBoxWithRestriction_handle.getRect().getPoint());
        System.out.println(resizableBoxWithRestriction_handle.getLocation().x);
        System.out.println(resizableBoxWithRestriction_handle.getLocation().y);
        Actions actions = new Actions(driver);
        actions.clickAndHold(resizableBoxWithRestriction_handle).perform();
        actions.moveToElement(resizableBoxWithRestriction_handle, width, height).perform();
//        actions.moveByOffset(width, height).perform();
        actions.release(resizableBoxWithRestriction_handle).perform();
        System.out.println(resizableBoxWithRestriction_handle.getRect().getPoint());
        return new InteractionsPage(driver);
    }

    public InteractionsPage ResizableBoxWithRestriction_handle_moveByOffset(int width, int height) {
        System.out.println(resizableBoxWithRestriction_handle.getRect().getDimension());
        System.out.println(resizableBoxWithRestriction_handle.getRect().getPoint());
        System.out.println(resizableBoxWithRestriction_handle.getLocation().x);
        System.out.println(resizableBoxWithRestriction_handle.getLocation().y);
        Actions actions = new Actions(driver);
        actions.clickAndHold(resizableBoxWithRestriction_handle).perform();
//        actions.moveToElement(resizableBoxWithRestriction_handle,width,height).perform();
        actions.moveByOffset(width, height).perform();
        actions.release(resizableBoxWithRestriction_handle).perform();
        System.out.println(resizableBoxWithRestriction_handle.getRect().getPoint());
        return new InteractionsPage(driver);
    }

    public InteractionsPage ResizableBoxWithRestriction_handle_dragAndDropBy(int width, int height) {
        System.out.println(resizableBoxWithRestriction_handle.getRect().getDimension());
        System.out.println(resizableBoxWithRestriction_handle.getRect().getPoint());
        System.out.println(resizableBoxWithRestriction_handle.getLocation().x);
        System.out.println(resizableBoxWithRestriction_handle.getLocation().y);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(resizableBoxWithRestriction_handle, width, height).perform();
        System.out.println(resizableBoxWithRestriction_handle.getRect().getPoint());
        return new InteractionsPage(driver);
    }

    public InteractionsPage ResizableNolimit_handle(int width, int height) {
        scrollIntoView(driver, resizableNolimit_handle);
        System.out.println(resizableNolimit_handle.getLocation().x);
        System.out.println(resizableNolimit_handle.getLocation().y);
        System.out.println(resizableNolimit_handle.getSize().height);
        System.out.println(resizableNolimit_handle.getSize().width);
        Actions actions = new Actions(driver);
        actions.clickAndHold(resizableNolimit_handle).perform();
        actions.moveByOffset(width, height).perform();
        actions.release(resizableNolimit_handle).perform();
        System.out.println(resizableNolimit_handle.getSize().height);
        System.out.println(resizableNolimit_handle.getSize().width);
        System.out.println(resizableNolimit_handle.getRect().getDimension());
        return new InteractionsPage(driver);
    }

    public InteractionsPage Simple_Droppable() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(simple_draggable, simple_droppable).perform();
        return new InteractionsPage(driver);
    }

    public InteractionsPage Simple_Droppable2() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(simple_draggable, driver.findElement(By.id("droppable"))).perform();
        return new InteractionsPage(driver);
    }

    public InteractionsPage RevertDraggable_Droppable() throws InterruptedException {
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        RevertDraggable_droppable_tab.click();
        WebElement revertable = driver.findElement(By.id("revertable"));
        WebElement notRevertable = driver.findElement(By.id("notRevertable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(revertable, driver.findElement(By.xpath("(//div[@id=\"droppable\"])[3]"))).perform();
        wait.until(ExpectedConditions.attributeToBe(revertable, "style", "position: relative; left: 0px; top: 0px;"));
        actions.dragAndDrop(revertable, driver.findElement(By.xpath("//a[@href='https://demoqa.com']"))).perform();
//        actions.clickAndHold(revertable).perform(); // can be used and working
        actions.clickAndHold().perform(); // can be used and working
        actions.moveToElement(driver.findElement(By.xpath("//*[text()='Widgets']"))).perform();
        actions.release().perform();// can be used and working
//        actions.release(revertable).perform();// can be used and working
        actions.clickAndHold().perform();
        actions.moveToElement(notRevertable, 20, 50).perform();
        actions.release().perform();
        Thread.sleep(5000);
        actions.clickAndHold(revertable).perform();
        actions.moveToElement(notRevertable).perform();
        actions.release().perform();
        Thread.sleep(5000);
        actions.dragAndDropBy(notRevertable,50,300).perform();
        actions.dragAndDropBy(revertable,70,150).perform();
        return new InteractionsPage(driver);
    }

    public InteractionsPage Simple_Droppable_Byoffset(int width, int height) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(simple_draggable, width, height).perform();
        return new InteractionsPage(driver);
    }
    public InteractionsPage Container_Restricted_Dragabble(int width, int height) {
        driver.findElement(By.id("draggableExample-tab-containerRestriction")).click();
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(driver.findElement(By.xpath("//div[text()=\"I'm contained within the box\"]")), width, height).perform();
        return new InteractionsPage(driver);
    }

}
