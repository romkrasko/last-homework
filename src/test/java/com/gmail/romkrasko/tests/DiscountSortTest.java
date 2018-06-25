package com.gmail.romkrasko.tests;

import com.gmail.romkrasko.pages.CamerasPage;
import com.gmail.romkrasko.pages.MainPage;
import com.gmail.romkrasko.pages.MarketPage;
import com.gmail.romkrasko.pages.RefrigeratorsPages;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.gmail.romkrasko.core.BrowserFactory.driver;

public class DiscountSortTest extends BaseTest {

    public static MainPage mainPage;
    public static MarketPage marketPage;
    public static RefrigeratorsPages refrigeratorsPage;


    @BeforeClass
    protected void initiliaze() {
        mainPage = new MainPage(driver);
        marketPage = new MarketPage(driver);
        refrigeratorsPage = new RefrigeratorsPages(driver);
    }

    @Test
    public void sortRefrigerators() {
        mainPage.clickMarketButton();
        marketPage.clickToTechniqueButton();
        marketPage.clickToRefrigeratorButton();
        refrigeratorsPage.sortDesc();
        refrigeratorsPage.sortDesc();
        Assert.assertTrue(refrigeratorsPage.checkSort());
    }
}

