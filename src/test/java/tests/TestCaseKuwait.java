package tests;


import Pages.HomePage;
import org.testng.annotations.Test;

public class TestCaseKuwait extends BaseTest {

    HomePage homePage;
    String countryName="Kuwait";

    @Test
    public void testTvPlansPrices_shouldBe_asInDataFile_forKuwait()  {
        HomePage homePage = new HomePage(driver);
        homePage.changeCountry(countryName);
        homePage.checkPricePlansKuwait();
    }
    @Test
    public void testTvPlanTypes_shouldBe_asInDataFile_forKuwait(){
        HomePage homePage = new HomePage(driver);
        homePage.changeCountry(countryName);;
        homePage.checkPlanType();
    }
    @Test
    public void testTvPlanCurrency_shouldBe_asInDataFile_forKuwait(){
        HomePage homePage = new HomePage(driver);
        homePage.changeCountry(countryName);;
        homePage.checkCountryCurrencyForEachPlan(countryName);
    }

}
