package Test;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertFrmWindowPage;
import pages.HomePage;
import pages.WidgetsPage;

public class AlertFrmWindowPageTest extends BaseTest {
    WebDriver driver;
    HomePage homePage;
    AlertFrmWindowPage page;

    @BeforeMethod
    public void beforeMethod() {
        driver = initialiseBrowserAndOpenWebsite("chrome");
    }

    @Test
    public void BrowserWindowsTest() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.homePageWindow();
        page = homePage.AlertsFrameWindowsCard();
        page.gotoBrowserWindows()
                .tabsAndWindows()
        ;
    }

    @Test
    public void AlertsTest() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.homePageWindow();
        page = homePage.AlertsFrameWindowsCard();
        page.gotoAlerts()
                .Alerts()
        ;
    }

    @Test
    public void FramesTest() {
        homePage = new HomePage(driver);
        homePage.homePageWindow();
        page = homePage.AlertsFrameWindowsCard();
        page.gotoFrames()
                .Frames()
        ;
    }

    @Test
    public void NestedFramesTest() {
        homePage = new HomePage(driver);
        homePage.homePageWindow();
        page = homePage.AlertsFrameWindowsCard();
        page.gotoNestedFrames()
                .NestedFrames()
        ;
    }

    @Test
    public void ModalDialogsTest() {
        homePage = new HomePage(driver);
        homePage.homePageWindow();
        page = homePage.AlertsFrameWindowsCard();
        page.gotoModalDialogs()
                .ModalDialogs()
        ;
    }
}
