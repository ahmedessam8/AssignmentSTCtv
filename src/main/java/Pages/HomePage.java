package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

import static utilities.TestData.*;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By countryChangeArrow = By.xpath("//span[@id='arrow']/img");
    By bahrainCountry = By.linkText("Bahrain");
    By kwaitCountry = By.linkText("Kuwait");
    By liteCurrency = By.linkText("Kuwait");

    By litePlanPrice = By.cssSelector("div#currency-lite > b");
    By classicPlanPrice = By.cssSelector("div#currency-classic > b");
    By premiumPlanPrice = By.cssSelector("div#currency-premium > b");

    By litePlanTitle = By.cssSelector("strong#name-lite");
    By classicPlanTitle = By.cssSelector("strong#name-classic");
    By premiumPlanTitle = By.cssSelector("strong#name-premium");

    By litePlanCurrency = By.cssSelector("div#currency-lite > i");
    By classicPlanCurrency = By.cssSelector("div#currency-classic > i");
    By premiumPlanCurrency = By.cssSelector("div#currency-premium > i");



    public void changeCountry(String countryName){
        if (countryName.equals("KSA")){

        } else if (countryName.equals("Bahrain")) {
            findElement(countryChangeArrow).click();
            findElement(bahrainCountry).click();
        }else if (countryName.equals("Kuwait")){
            findElement(countryChangeArrow).click();
            findElement(kwaitCountry).click();
        }
    }

    public void checkPricePlansKSA() {
        Assert.assertEquals(findElement(litePlanPrice).getText(), LITE_PRICE_PLAN_KSA);
        Assert.assertEquals(findElement(classicPlanPrice).getText(), CLASSIC_PRICE_PLAN_KSA);
        Assert.assertEquals(findElement(premiumPlanPrice).getText(), PREMIUM_PRICE_PLAN_KSA);
    }

    public void checkPricePlansKuwait() {
        Assert.assertEquals(findElement(litePlanPrice).getText(), LITE_PRICE_PLAN_KUWAIT);
        Assert.assertEquals(findElement(classicPlanPrice).getText(), CLASSIC_PRICE_KUWAIT);
        Assert.assertEquals(findElement(premiumPlanPrice).getText(), PREMIUM_PRICE_PLAN_KUWAIT);
    }

    public void checkPricePlansBahrain() {
        Assert.assertEquals(findElement(litePlanPrice).getText(), LITE_PRICE_PLAN_BAHRAIN);
        Assert.assertEquals(findElement(classicPlanPrice).getText(), CLASSIC_PRICE_BAHRAIN);
        Assert.assertEquals(findElement(premiumPlanPrice).getText(), PREMIUM_PRICE_PLAN_BAHRAIN);
    }

    public void checkPlanType() {
        Assert.assertEquals(findElement(litePlanTitle).getText(), LITE_PLAN_TITLE);
        Assert.assertEquals(findElement(classicPlanTitle).getText(), CLASSIC_PLAN_TITLE);
        Assert.assertEquals(findElement(premiumPlanTitle).getText(), PREMIUM_PLAN_TITLE);
    }

    public void checkCountryCurrencyForEachPlan(String countryName){
        if (countryName.equals("KSA")){
            Assert.assertTrue(findElement(litePlanCurrency).getText().contains("SAR"));
            Assert.assertTrue(findElement(classicPlanCurrency).getText().contains("SAR"));
            Assert.assertTrue(findElement(premiumPlanCurrency).getText().contains("SAR"));
        } else if (countryName.equals("Kuwait")) {
            Assert.assertTrue(findElement(litePlanCurrency).getText().contains("KWD"));
            Assert.assertTrue(findElement(classicPlanCurrency).getText().contains("KWD"));
            Assert.assertTrue(findElement(premiumPlanCurrency).getText().contains("KWD"));
        }else {
            Assert.assertTrue(findElement(litePlanCurrency).getText().contains("BHD"));
            Assert.assertTrue(findElement(classicPlanCurrency).getText().contains("BHD"));
            Assert.assertTrue(findElement(premiumPlanCurrency).getText().contains("BHD"));
        }
    }
}
