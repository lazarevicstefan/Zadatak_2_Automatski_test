package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AdresarTest extends BasicTest{
    @BeforeClass
    public void clearCookies(){
        homePage.deleteAllCookies();
    }
    @Test(priority = 1)
    public void verifyIsHomePageAndIsUserLogout() {
        Assert.assertTrue(homePage.isHomePage(),"There is not home page.");
        Assert.assertTrue(homePage.isUserNotLogin(),"User is login.");
    }
    @Test(priority = 2)
    public void openFirstProductOnDetailPage(){
        adresarPage.clickOnFirstProductOnePage();

        Assert.assertTrue(adresarPage.isDetailPageOfProductOpened(),"Detail page of product isn't opened.");
    }
    @Test(priority = 3)
    public void clickOn_DodajteUAdresar_buttonAndVerifyThatDoesNotAdded() throws InterruptedException {
        adresarPage.clickOn_DodajteUAdresar_button();

        Assert.assertTrue(adresarPage.verifyLoginPageIsDisplayed(),"Login page is not displayed correctly.");
    }
}
