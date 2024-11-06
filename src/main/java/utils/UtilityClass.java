package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class UtilityClass {
    public static String getValue(String key){
        String value = null;
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("src/main/resources/dataconfig.properties"));
            value = prop.getProperty(key);
        }catch (Exception e){}
        System.out.println(value);
        return value;
    }
    public static String getConfig(String key) {
        String value = null;
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("src/main/resources/Config.properties"));
            value = prop.getProperty(key);
        }catch (Exception e){}
        System.out.println(value);
        return value;
    }

    public static void clickOnMatch(List<WebElement> elements,String name){
        for (WebElement element:elements){
            if (element.getText().contains(name)){
                element.click();
                break;
            }
        }
    }
    public void removeGoogleAds (List < WebElement > elements,WebDriver driver){
        for (WebElement element : elements) {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].style.display='none'", element);
        }
    }
    public static  void switchToWindowUsingArraylistWithTitle(WebDriver driver,String title){
        Set windows=driver.getWindowHandles();
        ArrayList windowByindex=new ArrayList<>(windows);
        for (int i=0;i<windows.size();i++){
            String window= (String) windowByindex.get(i);
            driver.switchTo().window(window);
            System.out.println(i+1+" :: "+driver.getTitle());
            if (driver.getTitle().contains(title)){
                break;
            }
        }
    }
    public static  void switchToWindowUsingArraylistWithIndex(WebDriver driver,int windowIndex){
        Set windows=driver.getWindowHandles();
        ArrayList windowByindex=new ArrayList<>(windows);
        for (int i=0;i< windowByindex.size();i++){
            System.out.println(i+1 +" :: "+windowByindex.get(i));
        }
        System.out.println(windowByindex.get(windowIndex-1));
            driver.switchTo().window((String) windowByindex.get(windowIndex-1));

    }
    public static void closeOtherWindows(WebDriver driver){
        String CurrentWindow= driver.getWindowHandle();
        System.out.println(CurrentWindow);
        Set windows=driver.getWindowHandles();
        for (Object window:windows){
            driver.switchTo().window((String) window);
//            if (window.equals(CurrentWindow)){
//                System.out.println("CurrentWindow :: "+window);
//                System.out.println(driver.getTitle());
//            }else {
//                System.out.println("Window :: "+window);
//                System.out.println(driver.getTitle());
//                driver.close();
//            }
            if (!window.equals(CurrentWindow)){
                System.out.println("Window :: "+window);
                System.out.println(driver.getTitle());
                driver.close();
            }
//            if (window!=CurrentWindow){ //-----------------------------this is not correct to use with String, use like above one.
//                System.out.println("Window :: "+window);
//                System.out.println(driver.getTitle());
//                driver.close();
//            }
        }
        driver.switchTo().window(CurrentWindow);
    }
    public static WebElement returnWebElementOnMatch(List<WebElement> elements, String name){
        WebElement webElement = null;
        for (WebElement element:elements){
            if (element.getText().contains(name)){
                webElement=element;
                break;
            }
        }
        return webElement;
    }
    public static void clickOnMatchUsingJSExecutor(WebDriver driver,List<WebElement> elements,String name){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        for (WebElement element:elements){
            if (element.getText().contains(name)){
                js.executeScript("arguments[0].click()",element);
                break;
            }
        }
    }
    public static void scrollIntoView(WebDriver driver,WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()",element);
    }
    public void moveToElement(WebDriver driver,WebElement element){
        Actions actions=new Actions(driver);
        actions.moveToElement(element).perform();
    }
    public void ignore() {

    }
    public static void main(String[] args) throws IOException {
        getValue("name");
        getConfig("url");
    }
}
