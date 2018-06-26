package com.gmail.romkrasko.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(css = ".home-arrow__tabs div a:nth-child(5)")
    public WebElement marketButton;

    @FindBy(css = ".home-arrow__tabs div a:nth-child(7)")
    public WebElement musicButton;

    public void clickMarketButton() {
        marketButton.click();
    }

    public void clickMusicButton() {
        musicButton.click();
    }

}
