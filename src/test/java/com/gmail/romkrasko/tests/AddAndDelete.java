package com.gmail.romkrasko.tests;

import com.gmail.romkrasko.pages.MainPage;
import com.gmail.romkrasko.pages.MarketPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.gmail.romkrasko.core.BrowserFactory.driver;

public class AddAndDelete extends BaseTest {

    public static MainPage mainPage;
    public static MarketPage marketPage;


    @BeforeClass
    protected void initiliaze() {
        mainPage = new MainPage(driver);
        marketPage = new MarketPage(driver);
    }

    @Test
    public void addAndDelete() {
        mainPage.clickMarketButton();
        marketPage.sendValueInInput();
        marketPage.pressSearch();
        marketPage.addPhoneToCompare(1);
        marketPage.addPhoneToCompare(2);
        marketPage.clickToCompareButton();
        marketPage.compareProducts();
        Assert.assertTrue(marketPage.compareProducts());
        marketPage.deleteComparedPhone(2);
        marketPage.deleteComparedPhone(1);
        String expectedResult = marketPage.getNoProductsText();
        Assert.assertEquals(expectedResult, "Товаров нет");
    }
}
