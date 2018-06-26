package com.gmail.romkrasko.tests;

import com.gmail.romkrasko.pages.MainPage;
import com.gmail.romkrasko.pages.MarketPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.gmail.romkrasko.core.BrowserFactory.driver;

public class DiscountSortTest extends BaseTest {

    public static MainPage mainPage;
    public static MarketPage marketPage;


    @BeforeClass
    protected void initiliaze() {
        mainPage = new MainPage(driver);
        marketPage = new MarketPage(driver);
    }

    @Test
    public void sortRefrigerators() {
        mainPage.clickMarketButton();
        marketPage.clickToTechniqueButton();
        marketPage.clickToRefrigeratorButton();
        marketPage.sortByDiscount();
        Assert.assertTrue(marketPage.checkSortRefrigerators());
    }
}

