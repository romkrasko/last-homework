package com.gmail.romkrasko.tests;

import com.gmail.romkrasko.pages.MainPage;
import com.gmail.romkrasko.pages.MarketPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.gmail.romkrasko.core.BrowserFactory.driver;

public class SortCameras extends BaseTest {

    public static MainPage mainPage;
    public static MarketPage marketPage;


    @BeforeClass
    protected void initiliaze() {
        mainPage = new MainPage(driver);
        marketPage = new MarketPage(driver);
    }

    @Test
    public void sortCameras() {
        mainPage.clickMarketButton();
        marketPage.clickToElectronicButton();
        marketPage.clickToActionCamerasButton();
        marketPage.sortDesc();
        Assert.assertTrue(marketPage.checkSortCameras());
    }
}
