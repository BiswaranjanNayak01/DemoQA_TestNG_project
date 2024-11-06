package other;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class one extends BaseTest {
    WebDriver driver;
    @BeforeMethod
    public void before(){
        driver=initialiseBrowserAndOpenWebsite("");
        driver.get("https://demo.automationtesting.in/Register.html");
    }
    @Test
    public void test() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(5000);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//p[contains(@class,'oxd-text')])[1]"))));
//        WebElement element= driver.findElement(By.xpath("(//p[contains(@class,'oxd-text')])[1]"));
//        System.out.println(element.getText());
//        WebElement element1= driver.findElement(By.xpath("(//p[contains(@class,'oxd-text oxd-text--p')])[1]"));
//        System.out.println(element1.getText());
        WebElement element2= driver.findElement(By.xpath("//*[@class='col-md-3 col-xs-3 col-sm-3 control-label']"));
        System.out.println(element2.getText());
        WebElement element3= driver.findElement(By.className("col-md-3 col-xs-3 col-sm-3 control-label"));
        System.out.println(element3.getText());
    }
}
