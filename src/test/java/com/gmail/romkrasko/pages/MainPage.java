package com.gmail.romkrasko.pages;

import com.gmail.romkrasko.core.WaiterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;
WaiterClass waiter = new WaiterClass();
    @FindBy (css = ".desk-notif-card__login-title a:nth-child(1)")
    public WebElement mailButton;

    @FindBy(css = ".home-arrow__tabs div a:nth-child(1)")
    public WebElement videoButton;

    @FindBy(css = ".home-arrow__tabs div a:nth-child(2)")
    public WebElement picturesButton;

    @FindBy(css = ".home-arrow__tabs div a:nth-child(3)")
    public WebElement newsButton;

    @FindBy(css = ".home-arrow__tabs div a:nth-child(4)")
    public WebElement mapsButton;

    @FindBy(css = ".home-arrow__tabs div a:nth-child(5)")
    public WebElement marketButton;

    @FindBy(css = ".home-arrow__tabs div a:nth-child(6)")
    public WebElement translatorButton;

    @FindBy(css = ".home-arrow__tabs div a:nth-child(7)")
    public WebElement musicButton;

    @FindBy(css = ".b-langs div a span span")
    public WebElement changeLanguageButton;

    @FindBy(css = ".b-menu__item_pos_last div a")
    public WebElement moreLanguageButton;

    public void clickMailButton(){
        mailButton.click();
    }

    public String getMainPageUrl(){
        String mainPageUrl = driver.getCurrentUrl();
        return mainPageUrl;
    }

    public String getEnglishLanguageLabel(){
        waiter.WaitUntilElementIsEnable(changeLanguageButton);
        String languageButton = changeLanguageButton.getText();
        return languageButton;
    }

    public void clickVideoButton(){
        videoButton.click();
    }

    public void clickPicturesButton(){
        picturesButton.click();
    }

    public void clickNewsButton(){
        newsButton.click();
    }

    public void clickMapsButton(){
        mapsButton.click();
    }

    public void clickMarketButton(){
        marketButton.click();
    }

    public void clickTranslatorButton(){
        translatorButton.click();
    }

    public void clickMusicButton(){
        musicButton.click();
    }

    public void clickChangeLanguageButton(){
        changeLanguageButton.click();
        moreLanguageButton.click();
    }











}
