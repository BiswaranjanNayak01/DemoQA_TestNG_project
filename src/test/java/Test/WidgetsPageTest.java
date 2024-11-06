package Test;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.InteractionsPage;
import pages.WidgetsPage;

public class WidgetsPageTest extends BaseTest {
    WebDriver driver;
    HomePage homePage;
    WidgetsPage widgetsPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = initialiseBrowserAndOpenWebsite("chrome");
    }

    @Test
    public void AutoCompleteTest() {
        homePage = new HomePage(driver);
        homePage.homePageWindow();
        widgetsPage = homePage.WidgetsCard();
//        widgetsPage = new WidgetsPage(driver);
        widgetsPage.gotoAutoComplete()
                .autoCompleteMultipleInput_AutoComplete("R", "Red")
                .autoCompleteMultipleInput_AutoComplete("Y", "Yellow")
                .autoCompleteMultipleInput_AutoComplete("G", "Indigo")
                .autoCompleteSingleInput_AutoComplete("K", "Black");
    }

    @Test
    public void DatePickerTest() {
        homePage = new HomePage(driver);
        homePage.homePageWindow();
        widgetsPage = homePage.WidgetsCard();
//        widgetsPage = new WidgetsPage(driver);
        widgetsPage.gotoDatePicker().selectDate_usingSelectClass_way3();
    }

    @Test
    public void SliderTest() {
        homePage = new HomePage(driver);
        homePage.homePageWindow();
        widgetsPage = homePage.WidgetsCard();
//        widgetsPage = new WidgetsPage(driver);
        widgetsPage.gotoSlider().Slider(50);
    }

    @Test
    public void ProgressBarTest() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.homePageWindow();
        widgetsPage = homePage.WidgetsCard();
//        widgetsPage = new WidgetsPage(driver);
        widgetsPage.gotoProgressBar().ProgressBar("20", "No");
    }


/*
<div role="tooltip" x-placement="right" class="fade show tooltip bs-tooltip-right" id="buttonToolTip" style="position: absolute; inset: 0px auto auto 0px; transform: translate(402.4px, 280px);"><div class="arrow" style="position: absolute; top: 0px; transform: translate(0px, 8px);"></div><div class="tooltip-inner">You hovered over the Button</div></div>
 */

    @Test
    public void ToolTipsTest() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.homePageWindow();
        widgetsPage = homePage.WidgetsCard();
//        widgetsPage = new WidgetsPage(driver);
        widgetsPage.gotoToolTips().ToolTipsWithActionClass();
        widgetsPage.gotoToolTips().ToolTips();
    }

    @Test
    public void MenuTest() {
        homePage = new HomePage(driver);
        homePage.homePageWindow();
        widgetsPage = homePage.WidgetsCard();
        widgetsPage.gotoMenu().menu();
    }

    @Test
    public void SelectsTest() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.homePageWindow();
        widgetsPage = homePage.WidgetsCard();
        widgetsPage.gotoSelectMenu()
                .NewSelects("Select...", "Black")
                .NewSelects("Select Option", "A root option")
                .NewSelects("Select...","Blue")
                .NewSelects("Select Title", "Prof.")
                .NewSelects("Select...","Green")
                .NewSelects("Select...","Red")
                .oldSelectMenu("Voilet")
                .oldSelectMenu_multiSelect("Saab")
                .oldSelectMenu_multiSelect("Audi")
        ;
    }

}