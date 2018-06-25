package com.gmail.romkrasko.tests;

import com.gmail.romkrasko.core.WaiterClass;
import com.gmail.romkrasko.pages.MainPage;
import com.gmail.romkrasko.pages.MarketPage;
import com.gmail.romkrasko.pages.MusicPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.gmail.romkrasko.core.BrowserFactory.driver;

public class MetallicaTest extends BaseTest{

    public static MainPage mainPage;
    public static MusicPage musicPage;



    @BeforeClass
    protected void initiliaze() {
        mainPage = new MainPage(driver);
        musicPage = new MusicPage(driver);
    }


    @Test
    public void metallicaTest(){
        mainPage.clickMusicButton();
        musicPage.clickToLoginButton();
        musicPage.sendCrededentials("rkrasko","montolivo18");
        musicPage.sendMetal();
        musicPage.clickMetalica();
        Assert.assertEquals(musicPage.checkArtist(),"Metallica");
        musicPage.clickToAlbums();
        Assert.assertEquals(musicPage.checkArtist(),"Metallica");
    }
}