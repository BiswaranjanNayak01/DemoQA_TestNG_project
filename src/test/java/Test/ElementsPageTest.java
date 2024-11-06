package Test;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertFrmWindowPage;
import pages.ElementsPage;
import pages.HomePage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ElementsPageTest extends BaseTest {
    WebDriver driver;
    HomePage homePage;
    ElementsPage page;

    @BeforeMethod
    public void beforeMethod() {
        driver = initialiseBrowserAndOpenWebsite("chrome");
    }

    @Test
    public void WebTablesTest() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.homePageWindow();
        page = homePage.ElementsCard();
        page.gotoWebTables()
                .clickOnWebtableAdd()
                .WebTables("First Name","Biswa")
                .WebTables("Last Name","Nayak")
                .WebTables("Age","10")
                .WebTables("Salary","10000000")
                .WebTables("Department","Mechanical")
                .WebTables("name@example.com","Biswa@gmail.com")
                .Submit()
        ;
    }

    @Test
    public void LinksTest() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.homePageWindow();
        page = homePage.ElementsCard();
        page.gotoLinks()
                .links()
        ;
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/broken");

        //Storing the links in a list and traversing through the links
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // This line will print the number of links and the count of links.
        System.out.println("No of links are "+ links.size());

        //checking the links fetched.
        for(int i=0;i<links.size();i++)
        {
            WebElement E1= links.get(i);
            String url= E1.getAttribute("href");
            verifyLinks(url);
        }

        driver.quit();
    }


    public static void verifyLinks(String linkUrl)
    {
        try
        {
            URL url = new URL(linkUrl);

            //Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()>=400)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+" is a broken link");
            }

            //Fetching and Printing the response code obtained
            else{
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
        }catch (Exception e) {
        }
    }
}
