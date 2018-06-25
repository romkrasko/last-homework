package com.gmail.romkrasko.pages;

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

    @FindBy(xpath = "//a[@class='button button_size_L log-in not-handled']")
    public WebElement loginButton;

    @FindBy(xpath = "//input[@name='login']")
    public WebElement loginInput;

    @FindBy(xpath = "//input[@name='passwd']")
    public WebElement passwordInput;

    @FindBy(xpath = "//div[@class='nb-suggest _init head__suggest']/input")
    public WebElement searchInput;

    @FindBy(css = ".d-input__field.deco-input.deco-input_suggest")
    public WebElement searchInput2;



    @FindBy(xpath = "//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all nb-island nb-island_type_fly']/*[1]/*[1]")
    public WebElement metalica;

    @FindBy(xpath = "//div[@class='d-suggest__item d-suggest__item-artist']")
    public WebElement metalica2;

    @FindBy(xpath = "//div[@class='d-suggest__items d-suggest__items_type_artist']/*[2]")
    public WebElement beyonce2;


    @FindBy(xpath = "//div[@class='d-suggest__item d-suggest__item-artist deco-pane_show-hover-pressed']")
    public WebElement metalica22;

    @FindBy(xpath = "//div[@class='d-suggest__item d-suggest__item-artist deco-pane_show-hover-pressed']")
    public WebElement beyonce22;

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





    public WebDriver driver;

    public String getMusicPageUrl(){
        String musicPageUrl = driver.getCurrentUrl();
        return musicPageUrl;
    }

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
        waiter.wait(1000);
        driver.switchTo().window(tabs1.get(0));
    }

    public void sendMetal(){
        waiter.wait(3000);
        waiter.WaitUntilElementIsEnable(searchInput);
        try {
            searchInput.sendKeys("Metal");
            System.out.println("searchInput1");
        }catch (NoSuchElementException ex){
            searchInput2.sendKeys("M");
            searchInput2.sendKeys("e");
            searchInput2.sendKeys("t");
            searchInput2.sendKeys("a");
            waiter.wait(100);
            searchInput2.sendKeys("l");
            System.out.println("searchInput2");
        }
        waiter.wait(3000);
    }

    public void sendBeyo(){
        waiter.wait(3000);
        waiter.WaitUntilElementIsEnable(searchInput);
        try {
            searchInput.sendKeys("beyo");
            System.out.println("searchInput1");
        }catch (NoSuchElementException ex){
            searchInput2.sendKeys("b");
            searchInput2.sendKeys("e");
            searchInput2.sendKeys("y");
            waiter.wait(100);
            searchInput2.sendKeys("o");
            System.out.println("searchInput2");
        }
        waiter.wait(3000);
    }

    public void clickMetalica(){
        waiter.WaitUntilElementIsEnable(metalica);
        try{
            actions.moveToElement(metalica);
            actions.perform();
            metalica.click();
        }catch (NoSuchElementException ex){
            waiter.wait(100);
            actions.moveToElement(metalica2);
            actions.perform();
            waiter.wait(100);
            metalica22.click();
        }
    }

    public void clickBeyonce(){
        waiter.WaitUntilElementIsEnable(metalica);
        try{
            actions.moveToElement(metalica);
            actions.perform();
            metalica.click();
            waiter.wait(1000);
        }catch (NoSuchElementException ex){
            waiter.wait(100);
            actions.moveToElement(driver.findElement(By.cssSelector(".d-lang-switcher__current-lang-icon")));
            actions.perform();
            actions.moveToElement(beyonce2);
            actions.perform();
            waiter.wait(100);
            beyonce2.click();
            waiter.wait(1000);
        }
    }

    public String checkArtist(){
        waiter.WaitUntilElementIsEnable(artist);
        waiter.wait(1000);
        String artistName = artist.getText();
        return artistName;

    }

    public void clickToAlbums(){
        waiter.WaitUntilElementIsEnable(albums);
        actions.moveToElement(driver.findElement(By.cssSelector(".d-lang-switcher__current-lang-icon")));
        actions.perform();
        actions.moveToElement(albums);
        actions.perform();
        waiter.wait(1000);
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

        return res1 == res2;
    }

    public boolean cheskSlider() {
        String strSlider = slider.getAttribute("style");
        strSlider = strSlider.substring(8, strSlider.length() - 2);
        System.out.println(Double.parseDouble(strSlider));
        return Double.parseDouble(strSlider) != 0.0;
    }

}