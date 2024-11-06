package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static utils.UtilityClass.*;

public class WidgetsPage {
    @FindBy(className = "text")
    List<WebElement> subActions;
    @FindBy(id = "autoCompleteMultipleInput")
    WebElement autoCompleteMultipleInput;
    @FindBy(id = "autoCompleteSingleInput")
    WebElement autoCompleteSingleInput;
    @FindBy(xpath = "//div[contains(@class,\"auto-complete__option\")]")
    List<WebElement> autoCompleteOption;
    @FindBy(id = "datePickerMonthYearInput")
    WebElement datePickerMonthYearInput;
    @FindBy(className = "react-datepicker__year-select")
    WebElement atepickerYearSelect;
    @FindBy(xpath = "//input[@type='range']")
    WebElement slider;
    @FindBy(id = "resetButton")
    WebElement resetButton;
    @FindBy(id = "startStopButton")
    WebElement startStopButton;
    @FindBy(xpath = "//div[@id=\"progressBarContainer\"]/button")
    WebElement startStopesetButton;

    @FindBy(id = "toolTipButton")
    WebElement toolTipButton;
    @FindBy(id = "toolTipTextField")
    WebElement toolTipTextField;
    @FindBy(xpath = "//div[@role='tooltip']")
    List<WebElement> buttonToolTip;
    @FindBy(xpath = "//div[@role='tooltip']")
    WebElement buttonToolTip1;
    @FindBy(id = "textFieldToolTip")
    WebElement textFieldToolTip;
    @FindBy(xpath = "//ul[@id='nav']//a")
    List<WebElement> menuItems;
    @FindBy(xpath = "//div[contains(@class,\"option\")]")
    List<WebElement> options;
    @FindBy(xpath = "//div[contains(@class,\"css-1hwfws3\")]")    //only input section
//    @FindBy(xpath = "//div[contains(@class,\"control\")]")     // whole selectInputBox
    List<WebElement> NewSelects;
    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;
    @FindBy(id = "cars")
    WebElement oldSelectMenu_multiSelect;

    @FindBy(xpath = "//input[@id=\"react-select-4-input\"]/ancestor::div[contains(@class,\"control\")]")
    WebElement NewSelectMenu_multiSelect; // whole selectInputBox
    @FindBy(xpath = "//div[contains(@class,\"indicatorContainer\")][2]//*[local-name()='svg' and @class=\"css-19bqh2r\"]")
    WebElement NewSelectMenu_multiSelect_dropdown_Icon;
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public WidgetsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        actions=new Actions(this.driver);
    }

    public WidgetsPage gotoAccordian() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Accordian");
        return new WidgetsPage(driver);
    }

    public WidgetsPage gotoAutoComplete() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Auto Complete");
        return new WidgetsPage(driver);
    }

    public WidgetsPage gotoDatePicker() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Date Picker");
        return new WidgetsPage(driver);
    }

    public WidgetsPage gotoSlider() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Slider");
        return new WidgetsPage(driver);
    }

    public WidgetsPage gotoProgressBar() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Progress Bar");
        return new WidgetsPage(driver);
    }

    public WidgetsPage gotoTabs() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Tabs");
        return new WidgetsPage(driver);
    }

    public WidgetsPage gotoToolTips() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Tool Tips");
        return new WidgetsPage(driver);
    }

    public WidgetsPage gotoMenu() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Menu");
        return new WidgetsPage(driver);
    }

    public WidgetsPage gotoSelectMenu() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Select Menu");
        return new WidgetsPage(driver);
    }

    public WidgetsPage autoCompleteMultipleInput_AutoComplete(String colourName, String selectcolourName) {
        autoCompleteMultipleInput.sendKeys(colourName);
        wait.until(ExpectedConditions.visibilityOfAllElements(autoCompleteOption));
        clickOnMatch(autoCompleteOption, selectcolourName);
        return new WidgetsPage(driver);
    }

    public WidgetsPage autoCompleteSingleInput_AutoComplete(String colourName, String selectcolourName) {
        autoCompleteSingleInput.sendKeys(colourName);
        wait.until(ExpectedConditions.visibilityOfAllElements(autoCompleteOption));
        clickOnMatch(autoCompleteOption, selectcolourName);
        return new WidgetsPage(driver);
    }

    public WidgetsPage selectDate_usingKeys_way1() {
        datePickerMonthYearInput.sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
        datePickerMonthYearInput.sendKeys("08/01/2022");
        datePickerMonthYearInput.sendKeys(Keys.ENTER);
        return new WidgetsPage(driver);
    }

    public WidgetsPage selectDate_usingClicks_way2() {
        datePickerMonthYearInput.click();
        driver.findElement(By.xpath("//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]")).click();
        clickOnMatch(driver.findElements(By.xpath("//option")), "1900");
        //*[@class="react-datepicker__month-select"]/parent::div
        driver.findElement(By.xpath("//*[@class=\"react-datepicker__month-select\"]")).click();
        clickOnMatch(driver.findElements(By.xpath("//option")), "November");
        clickOnMatch(driver.findElements(By.xpath("//div[@role=\"option\"]")), "16");
        return new WidgetsPage(driver);
    }

    public WidgetsPage selectDate_usingSelectClass_way3() {
        datePickerMonthYearInput.click();
        Select s = new Select(driver.findElement(By.className("react-datepicker__year-select")));
        s.selectByVisibleText("1900");
        Select select = new Select(driver.findElement(By.xpath("//*[@class=\"react-datepicker__month-select\"]")));
        select.selectByVisibleText("November");
        clickOnMatch(driver.findElements(By.xpath("//div[@role=\"option\"]")), "16");
        return new WidgetsPage(driver);
    }

    public WidgetsPage Slider(int percentSize) {
        System.out.println("slider,getLocation() :: " + slider.getLocation());
        System.out.println("slider.getRectangle() :: " + slider.getRect() + "   <--->   slider.getSize() :: " + slider.getSize());
        slider.click();//---------intial click may reqired sometimes before dragAndDropBy.
        System.out.println("slider,getLocation() :: " + slider.getLocation());
        System.out.println("slider.getRectangle() :: " + slider.getRect() + "   <--->   slider.getSize() :: " + slider.getSize());
        Actions actions = new Actions(driver);
//        actions.clickAndHold(slider).perform();---------this may be used,it depends
//        actions.moveToElement(slider, -40, 0).perform();---------this will not work for sliders
        //below is my own logic
        actions.dragAndDropBy(slider, -(slider.getSize().width / 2) + ((slider.getSize().width / 100) * (percentSize + 2)), 0).perform();//----use of this is recommanded.
        actions.release(slider).perform();
        System.out.println("slider,getLocation() :: " + slider.getLocation());
        System.out.println("slider.getRectangle() :: " + slider.getRect() + "   <--->   slider.getSize() :: " + slider.getSize());
        return new WidgetsPage(driver);
    }

    public WidgetsPage ProgressBar(String percentSize, String refresh_YesNo) throws InterruptedException {
        startStopButton.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.textToBePresentInElementValue(driver.findElement(By.id("progressBar")),percentSize));
//        wait.pollingEvery(Duration.ofNanos(1));//this is necessary step otherwise will get 21% instead of 20% in line 155.
        wait1.pollingEvery(Duration.ofNanos(1)).until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//div[@role=\"progressbar\"]")), "aria-valuenow", percentSize));
        startStopButton.click();
        System.out.println(driver.findElement(By.id("progressBar")).getText());
        if (refresh_YesNo.contains("Yes")) {
            startStopButton.click();
            wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//div[@role=\"progressbar\"]")), "aria-valuenow", "100"));
//            Thread.sleep(5000);
            resetButton.click();
        }
        return new WidgetsPage(driver);
    }

    public WidgetsPage ToolTips() throws InterruptedException {
        toolTipButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(buttonToolTip));
        System.out.println(buttonToolTip.get(0).getText());
        System.out.println(buttonToolTip1.getText());
        actions.moveToElement(toolTipTextField).perform();
        toolTipTextField.click();

        wait.until(ExpectedConditions.visibilityOfAllElements(buttonToolTip));
        System.out.println(buttonToolTip.get(0).getText());
        wait.until(ExpectedConditions.visibilityOf(buttonToolTip1));
        System.out.println(buttonToolTip1.getText());

        wait.until(ExpectedConditions.visibilityOfAllElements(textFieldToolTip));
        System.out.println(textFieldToolTip.getText());

        Thread.sleep(3000);
        System.out.println(buttonToolTip1.getText());
        System.out.println(buttonToolTip.get(0).getText());
        return new WidgetsPage(driver);
    }

    public WidgetsPage ToolTipsWithActionClass() throws InterruptedException {
//        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        Thread.sleep(5000);
//        actions.moveToElement(toolTipButton).moveByOffset(1,1).perform();
//        actions.moveToElement(toolTipButton).perform();
        actions.moveToElement(toolTipButton).pause(Duration.ofSeconds(10)).perform();

//        actions.click().perform();

        wait.until(ExpectedConditions.visibilityOf(buttonToolTip1));
        System.out.println(buttonToolTip1.getText());

        actions.moveToElement(toolTipTextField).perform();

        wait.until(ExpectedConditions.visibilityOfAllElements(textFieldToolTip));
        System.out.println(textFieldToolTip.getText());

        return new WidgetsPage(driver);
    }
    public WidgetsPage menu(){
        Actions actions = new Actions(driver);
        actions.moveToElement(returnWebElementOnMatch(menuItems, "Main Item 1")).perform();
        actions.moveToElement(returnWebElementOnMatch(menuItems, "Main Item 3")).perform();
        actions.moveToElement(returnWebElementOnMatch(menuItems, "Main Item 2")).perform();
        actions.moveToElement(returnWebElementOnMatch(menuItems,"SUB SUB LIST »")).perform();
        actions.moveToElement(returnWebElementOnMatch(menuItems,"Sub Sub Item 2")).perform();
        System.out.println(returnWebElementOnMatch(menuItems,"Sub Sub Item 2").isSelected());
        System.out.println(returnWebElementOnMatch(menuItems,"Sub Sub Item 2").isDisplayed());
        System.out.println(returnWebElementOnMatch(menuItems,"Sub Sub Item 2").isEnabled());
        System.out.println(returnWebElementOnMatch(menuItems,"Sub Sub Item 2"));
        return new WidgetsPage(driver);
    }
    public WidgetsPage NewSelects(String select,String option) throws InterruptedException {
        if (select.contains("Select...")){
            actions.moveToElement(NewSelectMenu_multiSelect).perform();
            wait.until(ExpectedConditions.visibilityOf(NewSelectMenu_multiSelect));
            //For multiselect dropdowns you need to select the whole selectInputBox for click. not just the input section.
            NewSelectMenu_multiSelect.click();
            driver.findElement(By.id("react-select-4-input")).sendKeys(option);
            clickOnMatch(options,option);
            NewSelectMenu_multiSelect_dropdown_Icon.click();
        }
        clickOnMatch(NewSelects,select);
        clickOnMatch(options,option);
        return new WidgetsPage(driver);
    }

    public WidgetsPage oldSelectMenu(String option){
        Select select=new Select(oldSelectMenu);
        select.selectByVisibleText(option);
        return new WidgetsPage(driver);
    }
    public WidgetsPage oldSelectMenu_multiSelect(String option){
        Select select=new Select(oldSelectMenu_multiSelect);
        select.selectByVisibleText(option);
        return new WidgetsPage(driver);
    }
}
