package tests;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.AdresarPage;
import pages.AdvanceSearchPage;
import pages.HomePage;

import java.time.Duration;

public abstract class BasicTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseURL = "https://www.kupujemprodajem.com/";
    protected AdvanceSearchPage advanceSearchPage;
    protected HomePage homePage;
    protected AdresarPage adresarPage;

    @BeforeClass
    public void setup (){

        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().addCookie(new Cookie("cookie[emailSSL]","lazarevic.stefan%40dr.com"));
        driver.manage().addCookie(new Cookie("cookie[password_hashSSL]","3137724ecadfce44e80936f7b0ab7bd4"));
        driver.navigate().to(baseURL);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.advanceSearchPage = new AdvanceSearchPage(driver,wait);
        this.homePage = new HomePage(driver,wait);
        this.adresarPage = new AdresarPage(driver,wait);
    }


    @AfterClass
    public void exit(){
        driver.quit();
    }

}
