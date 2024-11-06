package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.UtilityClass;

import java.util.List;
import java.util.Set;


public class HomePage {
    @FindBy(xpath = "//div[@class='card-body']")
    public static List<WebElement> cards;

    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public HomePage homePageWindow(){
        String parent=driver.getWindowHandle();
//        System.out.println(parent);
        Set<String> windows=driver.getWindowHandles();
//        System.out.println(windows);
        for (String win:windows){
//            System.out.println(win);
            driver.switchTo().window(win);
//            System.out.println(driver.getTitle());
            if (!win.equals(parent)){
                driver.close();
            }
        }
        driver.switchTo().window(parent);//---------most necessary step
        return new HomePage(driver);
    }

    public InteractionsPage interactionCard(){
        UtilityClass utilityClass=new UtilityClass();
        utilityClass.scrollIntoView(driver,cards.get(cards.size()-1));
        utilityClass.clickOnMatch(cards,"Interactions");
        return new InteractionsPage(driver);
    }
    public ElementsPage ElementsCard(){
        UtilityClass utilityClass=new UtilityClass();
        utilityClass.scrollIntoView(driver,cards.get(cards.size()-1));
        utilityClass.clickOnMatch(cards,"Elements");
        return new ElementsPage(driver);
    }
    public FormsPage FormsCard(){
        UtilityClass utilityClass=new UtilityClass();
        utilityClass.scrollIntoView(driver,cards.get(cards.size()-1));
        utilityClass.clickOnMatch(cards,"Forms");
        return new FormsPage(driver);
    }
    public AlertFrmWindowPage AlertsFrameWindowsCard(){
        UtilityClass utilityClass=new UtilityClass();
        utilityClass.scrollIntoView(driver,cards.get(cards.size()-1));
        utilityClass.clickOnMatch(cards,"Alerts, Frame & Windows");
        return new AlertFrmWindowPage(driver);
    }
    public WidgetsPage WidgetsCard(){
        UtilityClass utilityClass=new UtilityClass();
        utilityClass.scrollIntoView(driver,cards.get(cards.size()-1));
        utilityClass.clickOnMatch(cards,"Widgets");
        return new WidgetsPage(driver);
    }

}
