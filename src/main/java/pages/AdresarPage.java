package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdresarPage extends BasicPage{
    public AdresarPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void clickOnFirstProductOnePage(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .xpath("//*[@id='__next']/div/div[3]/div/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/a")))
                .click();
    }
    public boolean isDetailPageOfProductOpened(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .xpath("//*[@aria-label='Dodajte u adresar']")))
                .isDisplayed();
    }

    public void clickOn_DodajteUAdresar_button(){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .xpath("//*[@aria-label='Dodajte u adresar']")))
                .click();
    }
    public boolean verifyLoginPageIsDisplayed(){
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .xpath("//*[@id=\"kp-portal\"]/div/div/aside/div/div/div[2]/main/h1")))
                .isDisplayed();
    }
}
