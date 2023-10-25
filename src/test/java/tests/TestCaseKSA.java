package tests;

import Pages.HomePage;
import org.testng.annotations.Test;

public class TestCaseKSA extends BaseTest {

    HomePage homePage;
    String countryName="KSA";

    @Test
    public void testTvPlansPrices_shouldBe_asInDataFile_forKSA()  {
        HomePage homePage = new HomePage(driver);
        homePage.checkPricePlansKSA();
    }
    @Test
    public void testTvPlanTypes_shouldBe_asInDataFile_forKSA(){
        HomePage homePage = new HomePage(driver);
        homePage.checkPlanType();
    }
    @Test
    public void testTvPlanCurrency_shouldBe_asInDataFile_forKSA(){
        HomePage homePage = new HomePage(driver);
        homePage.checkCountryCurrencyForEachPlan(countryName);
    }

//        homePage.changeCountryToBahrainCountry();
}
