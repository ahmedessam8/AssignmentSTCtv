package tests;


import Pages.HomePage;
import org.testng.annotations.Test;

public class TestCaseBahrin extends BaseTest {

    HomePage homePage;
    String countryName="Bahrain";

    @Test
    public void testTvPlansPrices_shouldBe_asInDataFile_forKSA()  {
        HomePage homePage = new HomePage(driver);
        homePage.changeCountry(countryName);
        homePage.checkPricePlansBahrain();
    }
    @Test
    public void testTvPlanTypes_shouldBe_asInDataFile_forBahrain(){
        HomePage homePage = new HomePage(driver);
        homePage.changeCountry(countryName);
        homePage.checkPlanType();
    }
    @Test
    public void testTvPlanCurrency_shouldBe_asInDataFile_forBahrain(){
        HomePage homePage = new HomePage(driver);
        homePage.changeCountry(countryName);
        homePage.checkCountryCurrencyForEachPlan(countryName);
    }
}
