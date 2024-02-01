package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdvanceSearchPage extends BasicPage {

    public AdvanceSearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickOnDetailSearchButton() throws InterruptedException {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath("//button[@aria-label='Pretražite detaljno ']")))
                .click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .xpath("//*[@data-state='show']")));
    }
    public boolean isAdvanceSearchBoxOpened(){
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .xpath("//div[contains(@class, 'Search_animated')][@data-state='show']")))
                .isDisplayed();
    }
    public boolean isAdvanceSearchBoxClosed() throws InterruptedException {
        Thread.sleep(1000);
        return wait.until(ExpectedConditions.attributeContains(By.xpath("//div[contains(@class, 'Search_animated')]"), "data-state", "hide"));

    }
    public void enterValueForCategorySearchAndSelectFirst(String value){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .id("react-select-categoryId-input")))
                .sendKeys(value + Keys.ENTER);
    }
    public String getEnteredValueForCategory(){
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[1]/span/div[1]/div/section/div/div/div[1]/div[1]")))
                .getText();
    }
    public void enterValueForGroupSearchAndSelectFirst(String value){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .id("react-select-groupId-input")))
                .sendKeys(value + Keys.ENTER);
    }
    public String getEnteredValueForCategoryGroup(){
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[1]/span/div[2]/div/section/div/div/div[1]/div[1]")))
                .getText();
    }
    public void enterAndSetMinPrice(int minPrice){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .id("priceFrom"))).clear();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .id("priceFrom")))
                .sendKeys(minPrice + "");
    }
    public int getEnteredMinPrice(){
        return Integer.parseInt(wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .id("priceFrom")))
                .getAttribute("value"));
    }
    public void enterAndSetMaxPrice(int maxPrice){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .id("priceTo"))).clear();

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .id("priceTo")))
                .sendKeys(maxPrice + "");
    }
    public int getEnteredMaxPrice(){
        return Integer.parseInt(wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .id("priceTo")))
                .getAttribute("value"));
    }
    public void selectDinForCurrency(){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .id("react-select-currency-input")))
                .sendKeys("din" + Keys.ENTER);
    }
    public void selectEurForCurrency(){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .id("react-select-currency-input")))
                .sendKeys("eur" + Keys.ENTER);
    }
    public String getSelectedCurrencyValue(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[2]/span/div[1]/div[3]/section/div/div/div[1]/div[1]")))
                .getText();
    }
    public void additionalFilterOfConditions_Novo(){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .id("react-select-condition-input")))
                .sendKeys("Novo" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[2]")).click();
    }
    public boolean isAdditionalFilterOfConditions_Novo_Checked(){

        List<WebElement> allCheckedFilters = driver.findElements(By
                .xpath("//*[@id='__next']/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[3]/span/div[1]/div/section/div/div[2]/input"));
        for (WebElement filter: allCheckedFilters) {
            if (filter.getAttribute("value").equals("new") ) return true;
        }
        return false;
    }
    public void additionalFilterOfConditions_KaoNovoNekorisceno(){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .id("react-select-condition-input")))
                .sendKeys("Kao novo (nekorisceno)" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[2]")).click();
    }
    public boolean isAdditionalFilterOfConditions_KaoNovoNekorisceno_Checked(){
        List<WebElement> allCheckedFilters = driver.findElements(By
                .xpath("//*[@id='__next']/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[3]/span/div[1]/div/section/div/div[2]/input"))
                .stream().toList();
        for (WebElement filter: allCheckedFilters) {
            if (filter.getAttribute("value").equals("as-new") ) return true;
        }
        return false;
    }
    public void additionalFilterOfConditions_Polovno(){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .id("react-select-condition-input")))
                .sendKeys("Polovno" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[2]")).click();
    }
    public boolean isAdditionalFilterOfConditions_Polovno_Checked(){
        List<WebElement> allCheckedFilters = driver.findElements(By
                .xpath("//*[@id='__next']/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[3]/span/div[1]/div/section/div/div[2]/input"))
                .stream().toList();
        for (WebElement filter: allCheckedFilters) {
            if (filter.getAttribute("value").equals("used") ) return true;
        }
        return false;
    }
    public void additionalFilterOfConditions_OstecenoIliNeispravno(){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .id("react-select-condition-input")))
                .sendKeys("Osteceno ili neispravno" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[2]")).click();
    }
    public boolean isAdditionalFilterOfConditions_OstecenoIliNeispravno_Checked(){
        List<WebElement> allCheckedFilters = driver.findElements(By
                .xpath("//*[@id='__next']/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[3]/span/div[1]/div/section/div/div[2]/input"))
                .stream().toList();
        for (WebElement filter: allCheckedFilters) {
            if (filter.getAttribute("value").equals("damaged")) return true;
        }
        return false;
    }
    public void additionalFilterOfConditions_NudiSe(){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .id("react-select-type-input")))
                .sendKeys("Nudi se" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[2]")).click();
    }
    public void additionalFilterOfConditions_TraziSe(){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .id("react-select-type-input")))
                .sendKeys("Trazi se" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[2]")).click();
    }
    public void additionalFilterOfConditions_Period_DanasnjiOglasi(){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .id("react-select-period-input")))
                .sendKeys("Danasnji oglasi" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[2]")).click();
    }

    public void additionalFilterOfConditions_Period_PoslednjaTriDana(){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .id("react-select-period-input")))
                .sendKeys("Poslednja 3 dana" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[2]")).click();
    }
    public void additionalFilterOfConditions_Period_PoslednjihSedamDana(){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .id("react-select-period-input")))
                .sendKeys("Poslednjih 7 dana" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[2]")).click();
    }
    public String witchAdditionalFilterOfConditions_Period_isSelected(){
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[3]/span/div[3]/div/section/div/div/div[1]/div[1]")))
                .getText();
    }
    public void enterValueForCitySearchAndSelectFirst (String city){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .id("react-select-locationId-input")))
                .sendKeys(city + Keys.ENTER);
    }
    public String getCityValue(){
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[1]/span/div[3]/div[1]/section/div/div/div[1]/div[1]")))
                .getText();
    }

    public void check_SamoSaCenom_box(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Samo sa cenom']"))).click();
    }
    public boolean isChecked_SamoSaCenom_box(){
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[2]/span/div[2]/div[1]/span")))
                .getAttribute("aria-checked").contains("true");
    }
    public void check_Besplatno_box(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Besplatno']"))).click();
    }
    public boolean isChecked_Besplatno_box(){
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[2]/span/div[2]/div[2]/span")))
                .getAttribute("aria-checked").contains("true");
    }
    public void check_MogucaZamena_box(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Moguća zamena']"))).click();
    }
    public boolean isChecked_MogucaZamena_box(){
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[2]/span/div[3]/div[1]/span")))
                .getAttribute("aria-checked").contains("true");
    }
    public void check_Kontakt_box(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@for]//*[text()='Kontakt']"))).click();
    }
    public boolean isChecked_Kontakt_box(){
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .xpath("//*[@id=\"__next\"]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[2]/span/div[3]/div[2]/span")))
                .getAttribute("aria-checked").contains("true");
    }
    public void check_PretraziITekstOglasa_box(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Pretraži i tekst oglasa']"))).click();
    }
    public void check_SamoOglasiSaSlikama_box(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Samo oglasi sa slikama']"))).click();
    }
    public void clickOn_PrimeniFiltere_Button (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Primeni filtere']"))).click();
    }
    public void clickOn_ResetujFiltere_Button (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Resetuj filtere']"))).click();
    }


}
