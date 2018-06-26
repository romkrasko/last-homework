package com.gmail.romkrasko.tests;

import com.gmail.romkrasko.pages.MainPage;
import com.gmail.romkrasko.pages.MusicPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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

    @BeforeMethod
    public void logIntoYaMusic(){
        mainPage.clickMusicButton();
        musicPage.clickToLoginButton();
        musicPage.sendCrededentials("rkrasko","montolivo18");
    }


    @Test
    public void metallicaTest(){
        musicPage.sendInInput("Metal");
        musicPage.clickOption();
        Assert.assertEquals(musicPage.checkArtist(),"Metallica");
        musicPage.clickToAlbums();
        Assert.assertEquals(musicPage.checkArtist(),"Metallica");
    }
}