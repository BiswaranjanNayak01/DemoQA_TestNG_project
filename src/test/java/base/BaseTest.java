package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;

import static utils.UtilityClass.getConfig;

public class BaseTest {
    WebDriver driver;

    public WebDriver initialiseBrowserAndOpenWebsite(String BrowserName){
        String browser = BrowserName.toLowerCase();
        switch (browser) {
            case "chrome":
                ChromeOptions opt=new ChromeOptions();
                opt.addExtensions(new File("src/main/resources/AdBlock-—-best-ad-blocker.crx"));
                driver = new ChromeDriver(opt);
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        try {
            Thread.sleep(5000);
        }catch (Exception e){}
        driver.switchTo().window(driver.getWindowHandle());
        driver.navigate().to(getConfig("url"));

        return driver;
    }
    public void refresh(WebDriver driver){
        driver.navigate().refresh();
    }
}
