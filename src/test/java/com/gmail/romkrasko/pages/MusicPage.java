package com.gmail.romkrasko.pages;

import com.gmail.romkrasko.core.Utils;
import com.gmail.romkrasko.core.WaiterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MusicPage {

    private Actions actions;
    public MusicPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.actions =  new Actions(driver);
    }

    WaiterClass waiter = new WaiterClass();
    private Utils utils = new Utils();

    @FindBy(xpath = "//a[@class='button button_size_L log-in not-handled']")
    public WebElement loginButton;

    @FindBy(xpath = "//input[@name='login']")
    public WebElement loginInput;

    @FindBy(xpath = "//input[@name='passwd']")
    public WebElement passwordInput;

    @FindBy(xpath = "//div[@class='head__search']/div/div/input")
    public WebElement searchInput;

    @FindBy(xpath = "//div[@class='d-suggest__items d-suggest__items_type_artist']/*[2]")
    public WebElement option;

    @FindBy(xpath = "//h1[@class='page-artist__title typo-h1_big']")
    public WebElement artist;

    @FindBy(xpath = "//div[@class='d-tabs deco-border']/*[3]")
    public WebElement albums;

    @FindBy(xpath = "//div[@class='page-artist__tracks_top']/*[1]//div[@class='d-track__cover']")
    public WebElement firstSong;

    @FindBy(xpath = "//div[@class='progress__bar progress__progress']/*[1]")
    public WebElement progressBar;

    @FindBy(xpath = "//div[@class='d-slider-vert volume__slider']/div/div")
    public WebElement slider;

    @FindBy(css = ".d-lang-switcher__current-lang-icon")
    public WebElement rusFlag;

    public WebDriver driver;

    public void clickToLoginButton(){
        waiter.WaitUntilElementIsEnable(loginButton);
        loginButton.click();
    }

    public void sendCrededentials(String login,String password){
        ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs1.get(1));
        waiter.WaitUntilElementIsEnable(loginInput);
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        driver.findElement(By.cssSelector(".passport-Button")).click();
        driver.switchTo().window(tabs1.get(0));
    }

    public void sendInInput(String key){
        waiter.WaitUntilElementIsEnable(searchInput);
        for(int i = 0; i<key.length();i++)
        searchInput.sendKeys(""+key.charAt(i)+"");
    }

    public void clickOption(){
        waiter.WaitUntilElementIsEnable(option);
        utils.customMove(rusFlag);
        utils.customMove(option);
        option.click();
    }

    public String checkArtist(){
        waiter.WaitUntilElementIsEnable(artist);
        String artistName = artist.getText();
        return artistName;

    }

    public void clickToAlbums(){
        utils.customMove(rusFlag);
        utils.customMove(albums);
        albums.click();
    }

    public void playSong(){
        waiter.WaitUntilElementIsEnable(firstSong);
        firstSong.click();
    }

    public boolean checkProgress() {
        waiter.WaitUntilElementIsEnable(progressBar);

        int res1 = progressBar.getAttribute("style").length();
        waiter.wait(5000);
        int res2 = progressBar.getAttribute("style").length();

        return res1 != res2;
    }

    public boolean cheskSlider() {
        String strSlider = slider.getAttribute("style");
        strSlider = strSlider.substring(8, strSlider.length() - 2);
        return Double.parseDouble(strSlider) != 0.0;
    }

}