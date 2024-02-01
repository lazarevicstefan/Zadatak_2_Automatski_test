package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class HomePage extends BasicPage{

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public boolean isHomePage(){
        return driver.getCurrentUrl().contains("https://www.kupujemprodajem.com/");
    }
    public void deleteAllCookies(){
        Set<Cookie> allCookies = driver.manage().getCookies();
        for (Cookie cookie : allCookies) {
            driver.manage().deleteCookieNamed(cookie.getName());
        }
        driver.navigate().refresh();
    }
    public boolean isUserNotLogin(){
        boolean isUserLog = false;
        for (Cookie cookie: driver.manage().getCookies()){
            if (cookie.getName().equals("cookie[password_hashSSL]")){
                isUserLog = true;
            }
        }
        return !isUserLog;
    }

    public void navigateToHomePage(){
        driver.navigate().to("https://www.kupujemprodajem.com/");
    }
    public String getNumberOfResultProducts(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div/span//div/span"))).getText();
    }

}
