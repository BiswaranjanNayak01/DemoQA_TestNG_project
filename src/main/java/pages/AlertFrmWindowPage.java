package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static utils.UtilityClass.*;

public class AlertFrmWindowPage {
    @FindBy(className = "text")
    List<WebElement> subActions;
    @FindBy(xpath = "//*[@class=\"btn btn-primary\"]")
    List<WebElement> clickMe;
    @FindBy(id = "frame1")
    WebElement frame1;
    @FindBy(id = "showSmallModal")
    WebElement showSmallModal;
    @FindBy(id = "closeSmallModal")
    WebElement closeSmallModal;
    @FindBy(id = "showLargeModal")
    WebElement showLargeModal;
    @FindBy(id = "closeLargeModal")
    WebElement closeLargeModal;
    @FindBy(className = "modal-body")
    WebElement modalbody;
    @FindBy(xpath = "//button[contains(@class,\"btn btn-primary\")]")
    List<WebElement> tabsAndWindows;

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public AlertFrmWindowPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        actions = new Actions(this.driver);
    }

    public AlertFrmWindowPage gotoBrowserWindows() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Browser Windows");
        return new AlertFrmWindowPage(driver);
    }

    public AlertFrmWindowPage gotoAlerts() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Alerts");
        return new AlertFrmWindowPage(driver);
    }

    public AlertFrmWindowPage gotoFrames() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Frames");
        return new AlertFrmWindowPage(driver);
    }

    public AlertFrmWindowPage gotoNestedFrames() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Nested Frames");
        return new AlertFrmWindowPage(driver);
    }

    public AlertFrmWindowPage gotoModalDialogs() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Modal Dialogs");
        return new AlertFrmWindowPage(driver);
    }

    public AlertFrmWindowPage Alerts() throws InterruptedException {
//        Alert alert=driver.switchTo().alert();---------this will give error,because it could not find alert.
        clickMe.get(0).click();
        Alert alert = driver.switchTo().alert();//---------this will find alert.
        System.out.println(alert.getText());
        alert.accept();
        clickMe.get(1).click();
        Thread.sleep(7000);
        System.out.println(alert.getText());
        alert.accept();
        clickMe.get(2).click();
        System.out.println(alert.getText());
        alert.accept();
        clickMe.get(3).click();
        System.out.println(alert.getText());
        alert.sendKeys("Biswa Nayak");
        alert.accept();
        return new AlertFrmWindowPage(driver);
    }

    public AlertFrmWindowPage Frames() {
        driver.switchTo().frame(frame1);
        String frmText = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(frmText);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame2");
        String frmText2 = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(frmText2);
        return new AlertFrmWindowPage(driver);
    }

    public AlertFrmWindowPage NestedFrames() {
        driver.switchTo().frame(0);
        String frmText = driver.findElement(By.xpath("/html/body")).getText();
        System.out.println("1 :: " + frmText);

        driver.switchTo().frame(0);
        String frmText2 = driver.findElement(By.xpath("/html/body/p")).getText();
        System.out.println("2 :: " + frmText2);

        driver.switchTo().parentFrame();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@srcdoc=\"<p>Child Iframe</p>\"]")));
        String frmText3 = driver.findElement(By.xpath("/html/body/p")).getText();
        System.out.println("3 :: " + frmText3);
        System.out.println("4 :: " + driver.findElement(By.xpath("//body")).getText());
//        System.out.println(driver.findElement(By.xpath("/body")).getText());--------giving error because full xpath starts from first node, can't start from middle.
        System.out.println("5 :: " + driver.findElement(By.xpath("/html/body")).getText());
        System.out.println("6 :: " + driver.findElement(By.tagName("body")).getText());
        return new AlertFrmWindowPage(driver);
    }

    public AlertFrmWindowPage ModalDialogs() {
        showSmallModal.click();
        System.out.println(modalbody.getText());
        closeSmallModal.click();
        showLargeModal.click();
        System.out.println(modalbody.getText());
        closeLargeModal.click();
        return new AlertFrmWindowPage(driver);
    }
    public AlertFrmWindowPage tabsAndWindows() throws InterruptedException {
        JavascriptExecutor js= (JavascriptExecutor) driver;
        System.out.println("New Tab");
        clickOnMatch(tabsAndWindows,"New Tab");
        switchToWindowUsingArraylistWithIndex(driver,2);
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        switchToWindowUsingArraylistWithTitle(driver,"DEMOQA");
        closeOtherWindows(driver);
        System.out.println("New Window");
        clickOnMatch(tabsAndWindows,"New Window");
        switchToWindowUsingArraylistWithIndex(driver,2);
        System.out.println("will print js executor");
        System.out.println(js.executeScript("return document.querySelector(\"body\").innerText"));
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        switchToWindowUsingArraylistWithTitle(driver,"DEMOQA");
        System.out.println("will print js executor");
        System.out.println(js.executeScript("return document.querySelector(\"#sampleHeading\")"));
        closeOtherWindows(driver);
        System.out.println("New Window Message");
        clickOnMatch(tabsAndWindows,"New Window Message");
        Set windows=driver.getWindowHandles();
        ArrayList windowByindex=new ArrayList<>(windows);
        System.out.println(windowByindex);
        switchToWindowUsingArraylistWithIndex(driver,2);
        Thread.sleep(5000);
//        System.out.println(js.executeScript("return document.querySelector(\"body\").innerText"));

//        System.out.println(driver.getCurrentUrl());
        driver.close();
        switchToWindowUsingArraylistWithIndex(driver,1);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

//        System.out.println(js.executeScript("return window.document.activeElement.innerHTML;"));
        driver.close();
//        System.out.println(driver.getPageSource());
//        System.out.println(driver.findElement(By.xpath("/html/body")).getText());
//        switchToWindowUsingArraylistWithTitle(driver,"DEMOQA");
//        closeOtherWindows(driver);

        return  new AlertFrmWindowPage(driver);
    }

}
