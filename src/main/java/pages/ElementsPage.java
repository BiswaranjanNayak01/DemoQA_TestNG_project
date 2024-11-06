package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;

import static utils.UtilityClass.clickOnMatchUsingJSExecutor;

public class ElementsPage {
    @FindBy(className = "text")
    List<WebElement> subActions;
    @FindBy(xpath = "//*[contains(@class,\"mr-sm-2 form-control\")]")
    List<WebElement> registrationFormInputField;
    @FindBy(css = "[type=\"submit\"]")
    WebElement submitButton;
    WebDriver driver;

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ElementsPage gotoWebTables() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Web Tables");
        return new ElementsPage(driver);
    }

    public ElementsPage gotoTextBox() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Text Box");
        return new ElementsPage(driver);
    }

    public ElementsPage gotoCheckBox() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Check Box");
        return new ElementsPage(driver);
    }

    public ElementsPage gotoRadioButton() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Radio Button");
        return new ElementsPage(driver);
    }

    public ElementsPage gotoButtons() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Buttons");
        return new ElementsPage(driver);
    }

    public ElementsPage gotoLinks() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Links");
        return new ElementsPage(driver);
    }

    public ElementsPage gotoBrokenLinksImages() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Broken Links - Images");
        return new ElementsPage(driver);
    }

    public ElementsPage gotoUploadandDownload() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Upload and Download");
        return new ElementsPage(driver);
    }

    public ElementsPage gotoDynamicProperties() {
        clickOnMatchUsingJSExecutor(driver, subActions, "Dynamic Properties");
        return new ElementsPage(driver);
    }

    public ElementsPage clickOnWebtableAdd() {
        if (driver.findElement(By.cssSelector("[class=\"btn btn-primary\"]")).isDisplayed()) {
            driver.findElement(By.cssSelector("[class=\"btn btn-primary\"]")).click();
        }
        return new ElementsPage(driver);
    }

    public ElementsPage WebTables(String elementName, String inputs) throws InterruptedException {
        for (WebElement element : registrationFormInputField) {
            if (element.getAttribute("placeholder").contains(elementName)) {
                element.sendKeys(inputs);
            }
        }
        return new ElementsPage(driver);
    }
    public ElementsPage Submit() throws InterruptedException {
        submitButton.submit();
        return new ElementsPage(driver);
    }
    public ElementsPage links() throws InterruptedException {
        String url="";
        List<WebElement> allURLs = driver.findElements(By.tagName("a"));
        System.out.println("Total links on the Wb Page: " + allURLs.size());

        //We will iterate through the list and will check the elements in the list.
        Iterator<WebElement> iterator = allURLs.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
        }
        return new ElementsPage(driver);
    }

}
