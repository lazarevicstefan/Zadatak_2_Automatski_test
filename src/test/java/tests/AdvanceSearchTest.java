package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class AdvanceSearchTest extends BasicTest{
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void openAdvanceSearchBoxAndVerify() throws InterruptedException {
        advanceSearchPage.clickOnDetailSearchButton();
        Assert.assertTrue(advanceSearchPage.isAdvanceSearchBoxOpened(),
                "Advance Search box isn't opened correctly.");
    }
    @Test(priority = 2)
    public void enterValueForCategoryAndVerify() {
        String enteredAndExpectedResult = "Odeća | Ženska";
        advanceSearchPage.enterValueForCategorySearchAndSelectFirst(enteredAndExpectedResult);

        Assert.assertEquals(advanceSearchPage.getEnteredValueForCategory(),enteredAndExpectedResult,
                "Actual attribute value doesn't match expected attribute value for category.");
    }
    @Test(priority = 3)
    public void enterValueForCategoryGroupAndVerify(){
        String enteredAndExpectedResult = "Bluze";
        advanceSearchPage.enterValueForGroupSearchAndSelectFirst(enteredAndExpectedResult);

        Assert.assertEquals(advanceSearchPage.getEnteredValueForCategoryGroup(),enteredAndExpectedResult,
                "Actual attribute value doesn't match expected attribute value for category group.");
    }
    @Test(priority = 4)
    public void enterMinimalPriceAndVerify(){
        int enteredAndExpectedResult = 100;
        advanceSearchPage.enterAndSetMinPrice(enteredAndExpectedResult);

        Assert.assertEquals(advanceSearchPage.getEnteredMinPrice(),enteredAndExpectedResult,
                "Actual minimal value doesn't match expected minimal value for price.");
    }
    @Test(priority = 5)
    public void select_Novo_FromAdditionalFilterAndVerify() {
        advanceSearchPage.additionalFilterOfConditions_Novo();

        Assert.assertTrue(advanceSearchPage.isAdditionalFilterOfConditions_Novo_Checked(),
                "Actual attribute doesn't selected as expected attribute for additional filter.");

    }
    @Test(priority = 6)
    public void select_KaoNovoNekorisceno_FromAdditionalFilterAndVerify(){
        advanceSearchPage.additionalFilterOfConditions_KaoNovoNekorisceno();

        Assert.assertTrue(advanceSearchPage.isAdditionalFilterOfConditions_KaoNovoNekorisceno_Checked(),
                "Actual attribute doesn't selected as expected attribute for additional filter.");
    }
    @Test(priority = 7)
    public void checkBox_SamoSaCenom_AndVerify(){
        advanceSearchPage.check_SamoSaCenom_box();

        Assert.assertTrue(advanceSearchPage.isChecked_SamoSaCenom_box(),
                "Actual attribute doesn't selected as expected attribute for checkbox 'Samo sa cenom'.");
    }

    @Test(priority = 8)
    public void applyAllChangesAndVerifyIsAdvanceSearchBoxIsClosed() throws InterruptedException {
        advanceSearchPage.clickOn_PrimeniFiltere_Button();

        Assert.assertTrue(advanceSearchPage.isAdvanceSearchBoxClosed(),"Advance Search box isn't opened correctly.");
    }
    @Test(priority = 9)
    public void isValidNumberOfProduct(){
        int minExpectedResult = 1000;
        String stringMinActualResult = homePage.getNumberOfResultProducts().split(" ")[0];
        int minActualResult;
        if (stringMinActualResult.contains(".")) {
            minActualResult = Integer.parseInt(stringMinActualResult.split("\\.")[0].concat(stringMinActualResult.split("\\.")[1]) + "");
        }else{
            minActualResult = Integer.parseInt(stringMinActualResult);
        }
        Assert.assertTrue(minActualResult > minExpectedResult, "Number of products is bellow 1000 for search result.");
    }
}
